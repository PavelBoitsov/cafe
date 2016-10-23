package cafe.model.dao;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.transaction.annotation.Transactional;

import cafe.controller.*;
import cafe.interfaces.iOrmMethods;
import cafe.model.entities.*;

public class CafeOrm implements iOrmMethods {
	private static final String DEFUALT_ORDER_STATUS = "open";
	private static final Client DEFAULT_ORDER_CLIENT = null;
	private static final double DEFAULT_ORDER_CHECK = 0.00;
	private static final int DEFAULT_N_GUESTS = 0;
	@PersistenceContext(unitName = "springHibernate", type = PersistenceContextType.EXTENDED)
	EntityManager em;

	// === ADD ===
	@Override
	@Transactional
	public boolean addSuppiler(SupplierData data) {
		boolean flag = false;
		if (data != null) {
			Supplier supplier = checkSupplier(data.getId());
			if (supplier == null) {
				em.persist(new Supplier(data.getId(), data.getInfo()));
				flag = true;
			}
		}
		return flag;
	}

	@Override
	@Transactional
	public boolean addProduct(ProductData data) {
		Product product = checkProduct(data.getProductName());
		if (product != null)
			return false;
		em.persist(new Product(data.getProductName(), data.getUnitName()));
		return true;
	}

	@Override
	@Transactional
	public boolean addInvoice(InvoiceData data) {

		// checking that supplier already exist
		Supplier supplier = checkSupplier(data.getSupplier().getId());
		if (supplier == null)
			return false;

		// checking that product already exist
		Product product = checkProduct(data.getProduct().getProductName());
		if (product == null)
			return false;

		// adding invoice
		em.persist(new Invoice(product, supplier, data.getDate(), data.getPrice(), data.getAmount()));

		// updating amount in table Products
		updateProductAmount(product, data.getAmount());

		// updating AVG price in table Product
		updateProductAvgPrice(product, data.getAmount(), data.getPrice());

		return true;
	}

	@Override
	@Transactional
	public boolean addRole(String newRole) {
		Role role = checkRole(newRole);
		if (role == null) {
			em.persist(new Role(newRole));
			return true;
		} else
			return false;
	}

	@Override
	@Transactional
	public boolean addStaff(StaffData data) {
		Role role = checkRole(data.getRole());
		if (role == null)
			return false;

		Staff staff = checkStaff(data.getId());
		if (staff == null) {
			em.persist(new Staff(data.getId(), role, data.getName(), data.getPassword()));
			return true;
		} else
			return false;
	}

	@Override
	@Transactional
	public boolean addTablePlace(TablePlaceData data) {
		TablePlace place = checkTablePlace(data.getId());
		if (place == null) {
			em.persist(new TablePlace(data.getId(), data.getTop(), data.getLeft(), data.getWidth(), data.getHeight()));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addOrderStatus(String newStatus) {
		OrderStatus status = checkOrderStatus(newStatus);
		if (status == null) {
			em.persist(new OrderStatus(newStatus));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addClient(ClientData data) {
		Client client = checkClient(data.getId());
		if (client == null) {
			em.persist(new Client(data.getId(), data.getName(), data.getBirthDay(), data.getDisount(), data.getInfo()));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addMenuGroup(MenuGroupData data) {
		MenuGroup menuGroup = checkMenuGroup(data.getId());
		if (menuGroup == null) {
			em.persist(new MenuGroup(data.getId(), data.getGroupName(), data.getSubGroupName()));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addMenuItem(MenuItemData data) {
		MenuItem menuItem = checkMenuItem(data.getMenuItem());
		if (menuItem != null)
			return false;

		MenuGroup menuGroup = checkMenuGroup(data.getMenuGroup().getId());
		if (menuGroup == null)
			return false;

		em.persist(new MenuItem(data.getMenuItem(), data.getPrice(), menuGroup));
		return true;
	}

	@Override
	@Transactional
	public boolean addCalculation(CalculationData calculationData) {
		Product product = checkProduct(calculationData.getProduct().getProductName());
		MenuItem menuItem = checkMenuItem(calculationData.getMenuItem().getMenuItem());
		if ((product != null) && (menuItem != null)) {
			em.persist(new Calculation(product, menuItem, calculationData.getCount()));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addCafeOrder(CafeOrderData cafeOrderData) {
		Staff staff = checkStaff(cafeOrderData.getStaffId());
		TablePlace tablePlace = checkTablePlace(cafeOrderData.getTableId());
		OrderStatus orderStatus = checkOrderStatus(DEFUALT_ORDER_STATUS);
		if ((staff != null) && (tablePlace != null)) {
			em.persist(new CafeOrder(staff, orderStatus, tablePlace, DEFAULT_ORDER_CLIENT, LocalDateTime.now(),
					DEFAULT_N_GUESTS, DEFAULT_ORDER_CHECK));
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean addItemQuantity(ItemQuantityData data) {
		CafeOrder order = checkOrder(data.getOrderId());
		MenuItem menuItem = checkMenuItem(data.getItem().getMenuItem());
		if ((order != null) && (menuItem != null)) {
			ItemQuantity iq = new ItemQuantity(menuItem, data.getQuantity(), order);
			iq.setPrice(data.getQuantity() * data.getItem().getPrice());
			order.setOrderCheck(order.getOrderCheck() + iq.getPrice());
			em.persist(iq);
			return true;
		}
		return false;
	}

	// updating amount in table Products
	private void updateProductAmount(Product product, int amount) {
		int newAmount = product.getBalance() + amount;
		product.setBalance(newAmount);
	}

	// updating AVG price in table Products
	private void updateProductAvgPrice(Product product, int amount, double price) {
		double invoicePrice = price / amount;
		if (product.getAvgPrice() == 0.00)
			product.setAvgPrice(invoicePrice);
		else {
			double newPrice = (product.getAvgPrice() + invoicePrice) / 2.0;
			product.setAvgPrice(newPrice);
		}
	}

	// ---- Checking data on the tables -----

	private CafeOrder checkOrder(long id) {
		return em.find(CafeOrder.class, id);
	}

	private MenuItem checkMenuItem(String item) {
		return em.find(MenuItem.class, item);
	}

	private MenuGroup checkMenuGroup(int group) {
		return em.find(MenuGroup.class, group);
	}

	private Client checkClient(int id) {
		return em.find(Client.class, id);
	}

	private Staff checkStaff(int id) {
		return em.find(Staff.class, id);
	}

	private Role checkRole(String role) {
		return em.find(Role.class, role);
	}

	private TablePlace checkTablePlace(int id) {
		return em.find(TablePlace.class, id);
	}

	private Supplier checkSupplier(int id) {
		return em.find(Supplier.class, id);
	}

	private Product checkProduct(String productName) {
		return em.find(Product.class, productName);
	}

	private OrderStatus checkOrderStatus(String status) {
		return em.find(OrderStatus.class, status);
	}

	// == SET PARAMETERS ==

	@Override
	@Transactional
	public boolean setClientToOrder(long orderId, int clientId) {
		CafeOrder order = checkOrder(orderId);
		Client client = checkClient(clientId);
		if ((order != null) && (client != null)) {
			order.setClient(client);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public boolean setNGuestsToOrder(long orderId, int nGuests) {
		CafeOrder order = checkOrder(orderId);
		if (order != null) {
			order.setnGuests(nGuests);
			return true;
		}
		return false;

	}

	@Override
	@Transactional
	public boolean setOrderStatus(long orderId, String newStatus) {
		CafeOrder order = checkOrder(orderId);
		OrderStatus status = checkOrderStatus(newStatus);
		if (order != null) {
			order.setOrderStatus(status);
			return true;
		}
		return false;

	}

	// == OTHER METHODS ==
	@Override
	@Transactional
	public boolean giveDiscountToOrder(long orderId, int discount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSupplier(SupplierData data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSuppilerById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProductById(String productName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteInvoiceById(long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Supplier getSupplierById(int id) {
		Supplier sup = em.find(Supplier.class, id);
		// TODO Auto-generated method stub
		return sup;
	}

}

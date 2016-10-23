package cafe.controller;

import java.time.*;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cafe.configuration.CafeConfiguration;
import cafe.interfaces.iOrmMethods;


public class CafeTestAppl {
	static AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
	static iOrmMethods cafeOrm = (iOrmMethods) ctx.getBean("cafe");
	static CafeConfiguration config = (CafeConfiguration) ctx.getBean("cafeConfiguration");

	public static void main(String[] args) {

		
		cafeOrm.addSuppiler(null);

//		loadConfiguration();
//		addDataToTables();

		// current tests
//		cafeOrm.setClientToOrder(1, 1);
//		cafeOrm.setNGuestsToOrder(1, 5);

		ctx.close();
	}

	private static void addDataToTables() {
		// test suppliers
		SupplierData[] supplier = { new SupplierData(1, "Supplier1"), new SupplierData(2, "Supplier2"),
				new SupplierData(3, "Supplier3"), new SupplierData(4, "Supplier4") };
		for (int i = 0; i < supplier.length; i++)
			cafeOrm.addSuppiler(supplier[i]);

		// test products
		ProductData[] product = { new ProductData("Milk", "ml"), new ProductData("Egg", "pieces"),
				new ProductData("Onion", "gram") };
		for (int i = 0; i < product.length; i++)
			cafeOrm.addProduct(product[i]);

		// test invoice
		InvoiceData[] invoice = { new InvoiceData(supplier[0], product[0], 15.0, 1500, LocalDate.of(2016, 10, 12)),
				new InvoiceData(supplier[1], product[1], 20.5, 30, LocalDate.of(2016, 10, 13)),
				new InvoiceData(supplier[2], product[2], 10.0, 2500, LocalDate.of(2016, 10, 13)),
				new InvoiceData(supplier[3], product[0], 10.0, 1000, LocalDate.of(2016, 10, 10)) };
		for (int i = 0; i < invoice.length; i++)
			cafeOrm.addInvoice(invoice[i]);

		// test staff
		StaffData[] staff = { new StaffData(1, "admin", "admin", "admin"),
				new StaffData(2, "waiter", "waiter1", "waiter1"), new StaffData(3, "waiter", "waiter2", "waiter2"),
				new StaffData(4, "manager", "manager", "manager") };
		for (int i = 0; i < staff.length; i++)
			cafeOrm.addStaff(staff[i]);

		// test clients
		ClientData[] client = { new ClientData(1, "Client1", LocalDate.of(1987, 2, 22), 10, "e-mail"),
				new ClientData(2, "Client2", LocalDate.of(1990, 4, 20), 20, "tel"),
				new ClientData(3, "Client3", LocalDate.of(1986, 12, 5), 50) };
		for (int i = 0; i < client.length; i++)
			cafeOrm.addClient(client[i]);

		// test menu groups
		MenuGroupData[] menuGroup = { new MenuGroupData(1, "Kithchen", "Eggs"),
				new MenuGroupData(2, "Kithchen", "Salads"), new MenuGroupData(3, "Kithchen", "Meat"),
				new MenuGroupData(4, "Deserts", "Ice Cream"), new MenuGroupData(5, "Deserts", "Cakes"),
				new MenuGroupData(6, "Kithchen", "Sandwiches"), new MenuGroupData(7, "Kithchen", "Snacks"),
				new MenuGroupData(8, "Bar", "Coctails"), new MenuGroupData(9, "Bar", "Caffe"),
				new MenuGroupData(10, "Bar", "Tea"), new MenuGroupData(11, "Bar", "Soft drinks"),
				new MenuGroupData(12, "Bar", "Beer"), new MenuGroupData(13, "Bar", "Whiskey") };
		for (int i = 0; i < menuGroup.length; i++)
			cafeOrm.addMenuGroup(menuGroup[i]);

		// test menu item
		MenuItemData[] menuItem = { new MenuItemData("Omelet", 20.5, menuGroup[0]) };
		for (int i = 0; i < menuItem.length; i++)
			cafeOrm.addMenuItem(menuItem[0]);

		// test calculation
		CalculationData[] calculationData = { new CalculationData(product[0], menuItem[0], 100),
				new CalculationData(product[1], menuItem[0], 2) };
		for (int i = 0; i < calculationData.length; i++)
			cafeOrm.addCalculation(calculationData[i]);

		// test CafeOrder
		CafeOrderData cafeOrder[] = { new CafeOrderData(2, 1) };
		for (int i = 0; i < cafeOrder.length; i++)
			cafeOrm.addCafeOrder(cafeOrder[0]);

		// test ItemQuantity
		long orderId = 1;
		ItemQuantityData[] itemQuantity = { new ItemQuantityData(menuItem[0], 2, orderId) };
		for (int i = 0; i < itemQuantity.length; i++)
			cafeOrm.addItemQuantity(itemQuantity[0]);
	}

	private static void loadConfiguration() {
		String[] statusConfig = config.getOrderStatus();
		String[] rolesConfig = config.getRoles();
		int nTables = config.getnTables();

		for (int i = 0; i < statusConfig.length; i++)
			cafeOrm.addOrderStatus(statusConfig[i]);
		for (int i = 0; i < rolesConfig.length; i++)
			cafeOrm.addRole(rolesConfig[i]);
		for (int i = 1; i <= nTables; i++) {
			String currentTable = "table" + i;
			cafeOrm.addTablePlace((TablePlaceData) ctx.getBean(currentTable));
		}
	}

}

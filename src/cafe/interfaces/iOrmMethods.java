package cafe.interfaces;

import java.time.*;
import java.util.*;
import cafe.controller.*;
import cafe.model.entities.*;

public interface iOrmMethods {
	
	// == ADD METHODS ==
	boolean addProduct(ProductData product);

	boolean addSuppiler(SupplierData data);

	boolean addInvoice(InvoiceData data);

	boolean addRole(String newRole);

	boolean addItemQuantity(ItemQuantityData data);

	boolean addCafeOrder(CafeOrderData cafeOrderData);

	boolean addCalculation(CalculationData calculationData);

	boolean addMenuItem(MenuItemData data);

	boolean addMenuGroup(MenuGroupData data);

	boolean addClient(ClientData data);

	boolean addOrderStatus(String newStatus);

	boolean addTablePlace(TablePlaceData data);

	boolean addStaff(StaffData data);

	// == SET PARAMETERS ==
	boolean setClientToOrder(long orderId, int clientId);

	boolean setNGuestsToOrder(long orderId, int nGuests);

	boolean setOrderStatus(long orderId, String status);

	// == UPDATE METHODS ==
	boolean updateSupplier (SupplierData data);
	

	// == DELETE METHODS ==
	
	boolean deleteSuppilerById (int id);
	boolean deleteProductById (String productName);
	boolean deleteInvoiceById (long id);


	// == GET METHODS ==
	
	
	// == OTHER METHODS ==
	boolean giveDiscountToOrder(long orderId, int discount);

	Supplier getSupplierById(int id);

	// == REPORTS ==
	// double getProfitByPeriod(LocalDateTime from, LocalDateTime to);
	// Map<Staff, Double> getProfitFromStaffByPeriod(LocalDateTime from,
	// LocalDateTime to);
	// Map<TablePlace, Double> getProfitFromTableByPeriod(LocalDateTime from,
	// LocalDateTime to);
	// Map<Product, Integer> getProductSalesByPeriod(LocalDateTime from,
	// LocalDateTime to);
	// List<Product> getProductsOnWarehouse();
	// double getAvgCheckByPeriod (LocalDateTime from, LocalDateTime to);

}

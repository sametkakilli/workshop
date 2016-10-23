package objects;

import java.util.List;

public interface SepetDao {

	public Sepet getProduct(int productId, int customerId);

	public List<Sepet> getBeforeProduct(int customerId);
}

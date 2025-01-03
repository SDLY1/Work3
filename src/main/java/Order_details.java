public class Order_details {
    private int order_id;
    private int goods_id;

    public Order_details(int order_id, int goods_id) {
        this.order_id = order_id;
        this.goods_id = goods_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    @Override
    public String toString() {
        return "order_details{" +
                "order_id=" + order_id +
                ", goods_id=" + goods_id +
                '}';
    }
}

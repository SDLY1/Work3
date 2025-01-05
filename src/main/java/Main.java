import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

//
//                插入商品面包，水，火腿。
//              DatabaseOperation.goodsInsert(1,"Bread",5);
//              DatabaseOperation.goodsInsert(2,"Water",1);
//              DatabaseOperation.goodsInsert(3,"Ham",3);
//              订单1中有买了一个火腿和水
//                DatabaseOperation.order_DetailsInsert(1,2);
//                DatabaseOperation.order_DetailsInsert(1,3);
//                Long datetime = System.currentTimeMillis();
//                Timestamp timestamp = new Timestamp(datetime);
                //将订单1得时间价格插入。
//                DatabaseOperation.orderInsert(1,timestamp,4);
                //更新火腿价格
//                  DatabaseOperation.goodsUpdatePriceById(3,5);
                //删除商品面包
//                    DatabaseOperation.goodsDeleteById(1);
                // 更新订单1价格
//                    DatabaseOperation.orderUpdatePriceById(1,6);
                //删除订单1中的水
//                    DatabaseOperation.orders_DetailsDeleteByGoodsId(1,2);
                    // 更新订单1价格
//                    DatabaseOperation.orderUpdatePriceById(1,5);
        //查询商品表
//            List<Goods> goods = DatabaseOperation.getGoodsById(3);
//            for (Goods gd : goods) {
//                System.out.println("Order ID: " + gd.getId() + ", Name: " + gd.getName() + ", Price: " + gd.getPrice());
//            }
        //查询订单详情表
//            List<Order_details> od = DatabaseOperation.getOrderDetailsById(1);
//            for (Order_details ods : od) {
//                System.out.println("Order ID: " + ods.getOrder_id() + ", Goods ID: " + ods.getGoods_id() );
//            }
                //查询订单表
//            List<Orders> Orders = DatabaseOperation.getOrdersById(1);
//            for (Orders order : Orders) {
//                System.out.println("Order ID: " + order.getId() + ", Time: " + order.getTime() + ", Price: " + order.getPrice());
//            }


    }

//    public static void main1()  throw {
//
//        StringBuffer sb = new StringBuffer();
//        StringBuffer append = sb.append(1);
//    }
}

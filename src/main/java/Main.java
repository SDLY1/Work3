import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        Timestamp TS=new Timestamp(2020);
//            DatabaseOperation.order_DetailsInsert(1,1);
//            DatabaseOperation.order_DetailsInsert(1,2);
//            DatabaseOperation.orders_DetailsDeleteByGoodsId(1,1);
//            DatabaseOperation.orderInsert(1,TS,2);
//            DatabaseOperation.orderInsert(1,TS,1);
//            DatabaseOperation.goodsInsert(2,"264",2);
//            DatabaseOperation.goodsUpdatePriceById(2,3);
        // 调用 getSortOrderByPrice 方法，例如按照价格升序排序，传入 "ASC" 或 "DESC"
            List<Orders> sortedOrders = DatabaseOperation.getSortOrderByTime("ASC");
            for (Orders order : sortedOrders) {
                System.out.println("Order ID: " + order.getId() + ", Time: " + order.getTime() + ", Price: " + order.getPrice());
            }


    }

//    public static void main1()  throw {
//
//        StringBuffer sb = new StringBuffer();
//        StringBuffer append = sb.append(1);
//    }
}

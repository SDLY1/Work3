import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperation {
    public DatabaseOperation() {
    }

    /**
     *  goodsInsert方法
     */
    public static void goodsInsert(int id,String name,double price) throws SQLException {
        // 判断价格是否合法
        if(price<0){
            System.out.println("价格不合法");
        }
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "insert into goods values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将三个占位符分别替换为id,name.price参数.
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);
            preparedStatement.setDouble(3,price);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("goodsInsert执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("goodsInsert执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    /**
     *  goodsDeleteById方法
     */
    public static void goodsDeleteById(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "delete from goods where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将占位符替换为id参数.
            preparedStatement.setInt(1,id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("goodsDeleteById执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("goodsDeleteById执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    /**
     *  goodsUpdatePriceById方法
     */
    public static void goodsUpdatePriceById(int id,double price) throws SQLException {
        // 判断价格是否合法
        if(price<0){
            System.out.println("价格不合法,更新失败");
        }
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "update goods set price = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将两个占位符替换为price，id参数.
            preparedStatement.setDouble(1,price);
            preparedStatement.setInt(2,id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("goodsUpdatePriceById执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("goodsUpdatePriceById执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     *  orderInsert方法
     */
    public static void  orderInsert(int id,Timestamp time,double price) throws SQLException {
        //检查价格是否合法
        if(!isPriceValid(price,id)){
            System.out.println("价格不合法,插入失败");
            return ;
        }
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "insert into orders values (?,?,?)";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将三个占位符分别替换为id,name.price参数.
            preparedStatement.setInt(1,id);
            preparedStatement.setTimestamp(2,time);
            preparedStatement.setDouble(3,price);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("orderInsert执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("orderInsert执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     *  orderDeleteById方法
     */
    public static void orderDeleteById(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "delete from orders where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将占位符替换为id参数.
            preparedStatement.setInt(1,id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("orderDeleteById执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("orderDeleteById执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     *  ordersUpdatePriceById方法
     */
    public static void orderUpdatePriceById(int id,int price) throws SQLException {
        //检查价格是否合法
        if(!isPriceValid(price,id)){
            System.out.println("价格不合法.更新失败");
            return ;
        }
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "update orders set price = ? where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将两个占位符替换为price，id参数.
            preparedStatement.setInt(1,price);
            preparedStatement.setInt(2,id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("orderUpdatePriceById执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("orderUpdatePriceById执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    /**
     *  orders_DetailsDeleteByGoodsId方法
     */
    public static void orders_DetailsDeleteByGoodsId(int order_id,int good_id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "delete from order_details where goods_id = ? and order_id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //替换占位符
            preparedStatement.setInt(1,good_id);
            preparedStatement.setInt(2,order_id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("orders_DetailsDeleteByGoodsId执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("orders_DetailsDeleteByGoodsId执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    /**
     *  order_DetailsInsert方法
     */
    public static void order_DetailsInsert(int order_id,int goods_id) throws SQLException {
        //检查商品是否存在
        if(!existGoods(goods_id)){
            System.out.println("商品不存在.插入失败");
            return;
        }
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "insert into Order_details values (?,?)";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //将两个占位符分别替换为order_id,godds_id参数.
            preparedStatement.setInt(1,order_id);
            preparedStatement.setInt(2,goods_id);
            //执行sql语句并获取受影响和的行数
            int i = preparedStatement.executeUpdate();
            //如果受影响行数为0，则判断为添加失败。
            if (i>0) {
                //成功则添加体提交
                connection.commit();
                System.out.println("order_DetailsInsert执行成功");
            }else{
                //失败则回滚
                connection.rollback();
                System.out.println("order_DetailsInsert执行失败");
            }
        } catch (SQLException throwables) {
            //失败则回滚
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
    /**
     * getGoodsById方法
     */
    public static List<Goods> getGoodsById(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        List<Goods> goods = new ArrayList<>();
        String sql="select id,name,price from goods where id = ?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            //获取查询后的结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            //将结果集的结果封装到类中
            while (resultSet.next()) {
                int Id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double Price = resultSet.getDouble("price");
                goods.add(new Goods(Id,name, Price));
            }
            connection.commit();
            return goods;
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return goods;
    }
    /**
     * getOrdersById方法
     */
    public static List<Orders> getOrdersById(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        String sql="select id,time,price from orders where id = ?";
        List<Orders> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            //获取查询后的结果集
            ResultSet resultSet = preparedStatement.executeQuery();

            //将结果集的结果封装到类中
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                Timestamp time = resultSet.getTimestamp("time");
                double orderPrice = resultSet.getDouble("price");
                orders.add(new Orders(orderId,time, orderPrice));
            }
            connection.commit();
            return orders;
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return  orders;
    }

    /**
     * getOrderDetailsById方法
     */
    public static List<Order_details> getOrderDetailsById(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        String sql="select order_id,goods_id from order_details where order_id = ?";
        List<Order_details> od = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                int goodsId = resultSet.getInt("goods_id");
                od.add(new Order_details(orderId,goodsId));
            }
            connection.commit();
            return od;
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return od;
    }

    /**
     * existGoods方法,判断商品是否合法
     */
    public static boolean existGoods(int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();

        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "select count(id) as num from goods where goods.id=?";
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            //执行sql语句并获取受影响和的行数
            ResultSet set = preparedStatement.executeQuery();

            System.out.println(set);
//            //如果受影响行数为0，则判断为不存在此商品。
            int res = 0;
           while(set.next()){
                res=set.getInt("num");
           }
//           System.out.println(res);
            //如果res为0，表示此商品编号不存在
           if(res==0){
               return false;
           }else{
               return true;
           }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    /**
     * isPriceValid方法,判断价格是否合法
     */
    public static boolean isPriceValid(double price,int id) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();

        // 这里的sql语句可以直接拼接成最终的sql语句，也可以把参数用？占位符代替，等会再传入。
        String sql = "select sum(price) as price from goods ,\n" +
                "    (select od.goods_id id from order_details as od where  od.order_id =?) as oog\n" +
                "where oog.id = goods.id";
        PreparedStatement preparedStatement = null;

        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
            //替换占位符
            preparedStatement.setInt(1,id);
            //执行sql语句并获取受影响和的行数
            ResultSet resultSet = preparedStatement.executeQuery();
            double sum=0;
            while (resultSet.next()) {
                 sum = resultSet.getDouble("price");
            }
//            System.out.println(sum);
            if(price==sum){
                return true;
            }else{
                return false;
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    /**
     * getSortOrderByTime方法,将订单按时间排序
     */
    public static List<Orders> getSortOrderByTime(String ord ) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        String sql="select id,time,price from orders order by time "+ord;
        List<Orders> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,ord);
            ResultSet resultSet = preparedStatement.executeQuery();

            //将结果集的结果封装到类中
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                Timestamp time = resultSet.getTimestamp("time");
                double orderPrice = resultSet.getDouble("price");
                orders.add(new Orders(orderId,time, orderPrice));
            }
            connection.commit();
            return orders;
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return orders;
    }
    /**
     * getSortOrderByPrice方法,将订单按价格排序
     */

    public static List<Orders> getSortOrderByPrice(String ord ) throws SQLException {
        // 获取数据库的链接
        Connection connection = LinkDatabase.getConnection();
        //关闭自动提交
        connection.setAutoCommit(false);
        String sql="select id,time,price from orders order by price "+ord;
        List<Orders> orders = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            //将sql语句传入,并用PreparedStatement 转义防止sql注入
            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,ord);
            ResultSet resultSet = preparedStatement.executeQuery();

            //将结果集的结果封装到类中
            while (resultSet.next()) {
                int orderId = resultSet.getInt("id");
                Timestamp time = resultSet.getTimestamp("time");
                double orderPrice = resultSet.getDouble("price");
                orders.add(new Orders(orderId,time, orderPrice));
            }
            connection.commit();
            return orders;
        } catch (SQLException throwables) {
            connection.rollback();
            throwables.printStackTrace();
        }finally{
            try {
                //结束调用，释放资源
                connection.close();
                preparedStatement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return orders;
    }
}

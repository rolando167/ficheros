package challenge;

import challenge.pojo.ProductSales;
import challenge.pojo.ProductStock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void testHappyPath() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));

        Long[] expectedResult = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals( expectedResult, Solution.sortProductsByScores(50, 50, productStock, productSales).toArray());
        //Assert.assertEquals(1,1);
        System.out.println("test Case passed");
    }


    /*
        Test - Validaciones
    */

    // Validacion 1
    @Test(expected = Exception.class)
    public void validation1() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(1L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();

        Long[] expectedResult = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals( Solution.sortProductsByScores(50, 50, productStock, productSales).toArray(), expectedResult);
    }

    // Validacion 2
    @Test(expected = Exception.class)
    public void validation2() throws Exception {
            List<ProductSales> productSales = new ArrayList<>();
            productSales.add(new ProductSales(1L, 10000.0));
            productSales.add(new ProductSales(2L, 50000.0));
            productSales.add(new ProductSales(3L, 100000.0));

            List<ProductStock> productStock = new ArrayList<>();
            productStock.add(new ProductStock(1L, 100000L));
            productStock.add(new ProductStock(2L, 400000L));
            productStock.add(new ProductStock(3L, 200000L));
            productStock.add(new ProductStock(4L, 300000L));

            Long[] expectedResult = {2L, 4L, 3L, 1L};

            Assert.assertArrayEquals( expectedResult, Solution.sortProductsByScores(50, 50, productStock, productSales).toArray());
            //Assert.assertEquals(1,1);
            System.out.println("test Case passed");

    }

    // Validacion 3
    @Test(expected = Exception.class)
    public void validation3() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, null));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));

        Long[] expectedResult = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals( expectedResult, Solution.sortProductsByScores(50, 50, productStock, productSales).toArray());
        //Assert.assertEquals(1,1);
        System.out.println("test Case passed");
    }

    // Validacion 4
    @Test(expected = Exception.class)
    public void validation4() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(5L, 100000L));
        productStock.add(new ProductStock(6L, 400000L));
        productStock.add(new ProductStock(7L, 200000L));
        productStock.add(new ProductStock(8L, 300000L));

        Long[] expectedResult = {2L, 4L, 3L, 1L};

        Assert.assertArrayEquals( expectedResult, Solution.sortProductsByScores(50, 50, productStock, productSales).toArray());
        //Assert.assertEquals(1,1);
        System.out.println("test Case passed");
    }

    // Validacion 5
    @Test(expected = Exception.class)
    public void validation5() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(1L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(1L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));

        Long[] expectedResult = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals( Solution.sortProductsByScores(50, 50, productStock, productSales).toArray(), expectedResult);
    }

    // Validacion 6
    @Test(expected = Exception.class)
    public void validation6() throws Exception {
        List<ProductSales> productSales = new ArrayList<>();
        productSales.add(new ProductSales(1L, 10000.0));
        productSales.add(new ProductSales(2L, 50000.0));
        productSales.add(new ProductSales(3L, 100000.0));
        productSales.add(new ProductSales(4L, 75000.0));

        List<ProductStock> productStock = new ArrayList<>();
        productStock.add(new ProductStock(1L, 100000L));
        productStock.add(new ProductStock(2L, 400000L));
        productStock.add(new ProductStock(3L, 200000L));
        productStock.add(new ProductStock(4L, 300000L));

        Long[] expectedResult = {2L, 4L, 3L, 1L};
        Assert.assertArrayEquals( Solution.sortProductsByScores(80, 40, productStock, productSales).toArray(), expectedResult);
    }

}
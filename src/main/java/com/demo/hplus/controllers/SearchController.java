package com.demo.hplus.controllers;

import com.demo.hplus.models.Product;
import com.demo.hplus.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.DeferredResult;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.Callable;

@Controller
public class SearchController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AsyncTaskExecutor asyncTaskExecutor;

 /* without async
    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        System.out.println("in search controller");
        System.out.println("search criteria: " + search);

        List<Product> products;
        products = productRepository.searchByName(search);
        model.addAttribute("products", products);

        return "search";
    }*/
/*  Callable async thread processing

    @GetMapping("/search")
    public Callable<String> search(@RequestParam("search") String search, Model model, HttpServletRequest httpServletRequest){
        System.out.println("in search controller");
        System.out.println("search criteria: " +search);
        System.out.println("is async: " + httpServletRequest.isAsyncSupported());
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());

        return ()->{
            Thread.sleep(3000);
            System.out.println("Thread of the spring mvc task executor: " +Thread.currentThread().getName());
            List<Product> products;
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);

            return "search";
        };
    }
  */

    @GetMapping("/search")
    public DeferredResult<String> search(@RequestParam("search") String search, Model model, HttpServletRequest httpServletRequest){

        DeferredResult<String> deferredResult = new DeferredResult<>();

        System.out.println("in search controller");
        System.out.println("search criteria: " + search );
        System.out.println("is async: " + httpServletRequest.isAsyncSupported());
        System.out.println("Thread from the servlet container: " + Thread.currentThread().getName());

        asyncTaskExecutor.execute(()->{
            try {
                Thread.sleep(6000);
            }catch (InterruptedException interruptedException){
                System.out.println("An InterruptedException Occured: " + interruptedException);
            }
            System.out.println("Thread of the spring mvc task executor: " + Thread.currentThread().getName());
            List<Product> products;
            products = productRepository.searchByName(search);
            model.addAttribute("products", products);
            deferredResult.setResult("search");

        });
        return deferredResult;
    }

}

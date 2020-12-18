/**
 * 
 */
package com.mindtree.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.order.dto.OrderListDto;
import com.mindtree.order.entity.OrderPlaced;
import com.mindtree.order.exception.OrderAppException;
import com.mindtree.order.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.exception.HystrixTimeoutException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author M1056182
 * @since 22/11/2020
 * 
 * <h1>Order Service Application</h1>
 * <p> Order Service contains Functionality to process an order.</p>
 * 
 *
 */

@RestController
@RequestMapping("/api/v1/orderservice/")
@Api(value = "Order Service", description = "List of Services available to make an order.", tags = { "Order Service" })
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

	
	/**
	 * @param orderListDtos
	 * @param customerId
	 * @return Order Details
	 * @throws OrderAppException
	 */
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully Placed an Order"),
			@ApiResponse(code = 404,message = "Failed to Process an Order."),
			@ApiResponse(code = 408,message = "Request Time Out"), 
			@ApiResponse(code = 500,message = "Internal Server Error")})
	@PostMapping("/order/{customerId}")
//	@HystrixCommand(fallbackMethod = "processOrderMissed", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000"),
//			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
//			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
//			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "2000")})
	public ResponseEntity<OrderPlaced> processOrder(@RequestBody List<OrderListDto> orderListDtos,@PathVariable int customerId) throws OrderAppException{
		return new ResponseEntity<>(orderService.processOrder(orderListDtos,customerId),HttpStatus.OK);
		
	}
	
	
//	/**
//	 * @param oAuth2User
//	 * @param throwable
//	 * @return Message Request Time Out Please Try After some time...! when other api response is taking much time
//	 * @throws UserAppException
//	 */
//	public ResponseEntity<?> processOrderMissed(@RequestBody List<OrderListDto> orderListDtos,@PathVariable int customerId,Throwable throwable) throws OrderAppException{
//		if ((throwable instanceof HystrixTimeoutException)  || (throwable instanceof RuntimeException)) {
//			logger.error("Request timed out occured from order while communicating with other service...!");
//			return new ResponseEntity<>("Request timed out. Please Try after some time...!",HttpStatus.REQUEST_TIMEOUT);
//		}
//		return new ResponseEntity<>(throwable.getLocalizedMessage(),HttpStatus.NOT_FOUND);
//
//	}

}

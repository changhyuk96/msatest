package src.test.gate.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
import src.test.gate.util.serviceUtil;

@Component
public class CustomAuthFilter extends AbstractGatewayFilterFactory<CustomAuthFilter.Config>{
	
	Logger logger = LoggerFactory.getLogger(CustomAuthFilter.class);
	
	@Autowired
	private serviceUtil serviceUtil;
	
    public CustomAuthFilter() {
        super(Config.class);
    }
    
    public static class Config {

    }

    @Override
    public GatewayFilter apply(Config config) {
    	
    	return ((exchange, chain) -> {
    		
    		try {
    			serviceUtil.validateAccessToken(exchange.getRequest().getHeaders().getFirst("jwtToken"));
    			
    		}
    		catch(Exception e) {
    			logger.info("CustomAuthFilter ::: Token Error :::" + e.getMessage());
    			return tokenHandler(exchange);
    		}
    		
    		return chain.filter(exchange);
        });
    }
    
    private Mono<Void> tokenHandler(ServerWebExchange exchange){
    	ServerHttpResponse response = exchange.getResponse();
    	
    	response.setStatusCode(HttpStatus.BAD_REQUEST);
    	return response.setComplete();
    }
    
}

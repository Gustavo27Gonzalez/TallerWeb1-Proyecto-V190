package ar.edu.unlam.tallerweb1.service.serviceImpl;
//import com.mercadopago.*;
//
//import com.mercadopago.client.payment.PaymentClient;
//import com.mercadopago.client.payment.PaymentCreateRequest;
//import com.mercadopago.client.payment.PaymentPayerRequest;
//import com.mercadopago.exceptions.MPApiException;
//import com.mercadopago.exceptions.MPException;
//import com.mercadopago.resources.payment.Payment;
import org.springframework.stereotype.Service;
//
//import java.math.BigDecimal;

@Service("mercadoPagoService")
public class ServicioMercadoPagoImpl {

//    public ServicioMercadoPagoImpl() throws MPException, MPApiException {
//    }
//
//    public Payment crearPago() throws MPException, MPApiException {
//        MercadoPagoConfig.setAccessToken("TEST-4642931363993034-113021-0ebf4b359b221f5dd62a6c87b90322bb-181683199");
//
//        PaymentClient client = new PaymentClient();
//
//        PaymentCreateRequest createRequest =
//                PaymentCreateRequest.builder()
//                        .transactionAmount(new BigDecimal(1000))
//                        .token("123")
//                        .description("description")
//                        .installments(1)
//                        .paymentMethodId("visa")
//                        .payer(PaymentPayerRequest.builder().email("TEST@MERCADOPAGO.COM").build())
//                        .build();
//        Payment payment = client.create(createRequest);
//        return payment;
//    }
}

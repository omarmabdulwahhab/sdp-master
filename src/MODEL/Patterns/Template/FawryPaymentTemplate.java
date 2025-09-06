package MODEL.Patterns.Tepmlate;

import MODEL.DTO.Donation.PaymentDTO;
import MODEL.Patterns.paymentstrategy.FawryPayment;
import MODEL.Patterns.paymentstrategy.PaymentMethode;
import View.UserView;
import java.sql.Connection;

/**
 *
 * @author Omar AbdulWahhab
 */
public class FawryPaymentTemplate extends DonationPaymentTemplate {

    private PaymentMethode paymentMethode;

     public FawryPaymentTemplate(UserView userView, Connection connection) {
        
        super(userView, connection);
        
        this.paymentMethode = new PaymentMethode(new FawryPayment());
    }

    @Override
    public void executePayment(PaymentDTO payment) {
        
    
        paymentMethode.executePayment(payment);
    }
}

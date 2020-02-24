package ar.com.rsoftware.mercadopago;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.resources.Preference;
import com.mercadopago.resources.datastructures.preference.BackUrls;
import com.mercadopago.resources.datastructures.preference.Item;
import com.mercadopago.resources.datastructures.preference.Payer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Controller
public class Controler {

    static {
        try {
            MercadoPago.SDK.setAccessToken("APP_USR-3241905158905030-022319-2ffa0632aa73fe53ffe651a288918ead-529858493");
        } catch (MPConfException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/")
    public String init(Model model) throws  Exception{



        // Crea un objeto de preferencia
        Preference preference = new Preference();
//        BackUrls backUrls = new BackUrls(
//                "181.31.83.62:25418/exitoso",
//                "http://www.tu-sitio/pending",
//                "http://www.tu-sitio/failure");
//        preference.setBackUrls(backUrls);

        Payer payer = new Payer();
        preference.setPayer(payer);

// Crea un ítem en la preferencia
        Item item = new Item();
        item.setTitle("Mi producto")
                .setQuantity(1)
                .setUnitPrice((float) 75.56);
        preference.appendItem(item);
        preference.save();
        model.addAttribute("a","a");
        System.out.println("test");
        model.addAttribute("preference",preference);
        return "index";
    }


    @PostMapping("/procesar-pago")
    public String exitoso (Model model) throws  Exception{
        // Crea un objeto de preferencia
        return "exitoso";
    }
}

package haw41k.wheels.catalog;


import haw41k.wheels.catalog.dao.DaoWheels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("wheelsForm")
public class SimpleController {

    @Autowired
    DaoWheels daoWheels;

    @GetMapping("/wheels")
    public String getWheels (Model model) {

        if (! model.containsAttribute("wheelsForm"))
            model.addAttribute("wheelsForm", new WheelsForm());

        WheelsForm wheelsForm = (WheelsForm) model.getAttribute("wheelsForm");

        model.addAttribute("brands", daoWheels.getBrandsAll());
        assert wheelsForm != null;

        model.addAttribute("models", daoWheels.getModelsByFilter(wheelsForm));

        model.addAttribute("sizeDiameters", daoWheels.getSizeDiameterAll());
        model.addAttribute("sizeWidths", daoWheels.getSizeWidthAll());
        model.addAttribute("pcdCounts", daoWheels.getPcdCountAll());
        model.addAttribute("pcdDiameters", daoWheels.getPcdDiameterAll());
        model.addAttribute("ets", daoWheels.getEtAll());
        model.addAttribute("dias", daoWheels.getDiaAll());

        return "wheels";
    }

    @PostMapping("/wheels")
    public String getWheelsForm (@ModelAttribute WheelsForm wheelsForm, Model model) {
        return "redirect:/wheels";
    }

    @GetMapping("/wheels/{id}")
    public String getWheel (@PathVariable int id, Model model) {
        model.addAttribute("model", daoWheels.getModelById(id));
        model.addAttribute("modelParams", daoWheels.getParamsByModelId(id));
        return "wheel";
    }
}



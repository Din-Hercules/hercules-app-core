import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IdkController {

    @GetMapping("/idk")
    fun getIdk():String = "idk"
}
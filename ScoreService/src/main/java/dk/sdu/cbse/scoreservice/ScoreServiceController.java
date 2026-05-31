package dk.sdu.cbse.scoreservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@RestController
@RequestMapping("/api/score")
public class ScoreServiceController {
    private int currentScore = 0;
    private boolean isCounting = false;

    public static void main(String[] args) {
        SpringApplication.run(ScoreServiceController.class, args);
    }

    @GetMapping("/start")
    public String start() {
        this.isCounting = true;
        this.currentScore = 0;
        return "Score-Module started";
    }

    @GetMapping("/update")
    public int update(@RequestParam int add) {
        if (isCounting) {
            this.currentScore += add;
            return currentScore;
        }
        else
            return 0;
    }

    @GetMapping("/stop")
    public String stop() {
        this.isCounting = false;
        return "Final score was: " + currentScore;
    }

    @GetMapping("/getScore")
    public int get(){
        return this.currentScore;
    }
}

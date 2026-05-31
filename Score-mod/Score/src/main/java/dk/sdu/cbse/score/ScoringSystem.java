package dk.sdu.cbse.score;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.*;
import dk.sdu.cbse.scoreComponent.ScoreComponent;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class ScoringSystem extends BaseLogicSystem {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String Url = "http://localhost:8080/api/score";
    private boolean hasStarted = false;
    private int currentScore = 0;
    private int lastScore = 0;

    @Override
    public void process(IWorld world, double deltaTime) {
        if (!hasStarted) {
            try {
                String response = restTemplate.getForObject(Url + "/start", String.class);
                if (Objects.equals(response, "Score-Module started")) {
                    hasStarted = true;
                }
            } catch (Exception e) {
            }
        } else {
            for (IEntity entity : world.getEntitiesWithComponent(ScoreComponent.class)) {
                try {
                    currentScore = Integer.parseInt(restTemplate.getForObject(Url + "/getScore", String.class));
                } catch (Exception e) {
                    System.out.println(e);
                }

                if (lastScore != currentScore) {
                    lastScore = currentScore;
                    System.out.println("Your score is: " + currentScore);
                }
            }
        }
    }
}

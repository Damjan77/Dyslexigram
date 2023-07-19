package com.example.dyslexigram.config;

import com.example.dyslexigram.model.Game;
import com.example.dyslexigram.model.Question;
import com.example.dyslexigram.model.Response;
import com.example.dyslexigram.model.enumerations.Level;
import com.example.dyslexigram.repository.GameRepository;
import com.example.dyslexigram.repository.QuestionRepository;
import com.example.dyslexigram.repository.ResponseRepository;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Getter
public class DataInitializer {

    private final GameRepository gameRepository;
    private final ResponseRepository responseRepository;
    private final QuestionRepository questionRepository;

    public DataInitializer(GameRepository gameRepository, ResponseRepository responseRepository, QuestionRepository questionRepository) {
        this.gameRepository = gameRepository;
        this.responseRepository = responseRepository;
        this.questionRepository = questionRepository;
    }

    @PostConstruct
    public void init() {
        /* --------------------------НИВО 1--------------------------------- */

        // Игра 1
        Response response1G1L1 = new Response("А");
        Response response2G1L1 = new Response("Е");
        Response response3G1L1 = new Response("И");
        Response response4G1L1 = new Response("О");

        this.responseRepository.save(response1G1L1);
        this.responseRepository.save(response2G1L1);
        this.responseRepository.save(response3G1L1);
        this.responseRepository.save(response4G1L1);

        List<Response> responseListG1L1 = new ArrayList<>(Arrays.asList(response1G1L1, response2G1L1, response3G1L1, response4G1L1));

        Question question1G1L1 = new Question("П_НЕДЕЛНИК", "", responseListG1L1, response4G1L1);
        Question question2G1L1 = new Question("УЧИТ_ЛКА", "", responseListG1L1, response2G1L1);
        Question question3G1L1 = new Question("_ВТОМОБИЛ", "", responseListG1L1, response1G1L1);

        this.questionRepository.save(question1G1L1);
        this.questionRepository.save(question2G1L1);
        this.questionRepository.save(question3G1L1);

        List<Question> questionListG1L1 = new ArrayList<>(Arrays.asList(question1G1L1, question2G1L1, question3G1L1));

        Game game1level1 = new Game("Погоди ја буквата",
                "Играта се состои од неколку зборови на кои им недостасуваат букви. Можете ли да погодете коjа буква недостасува?",
                Level.Ниво1, "/images/game.jpg", 3, questionListG1L1);

//        userGamePoints.setGame(game1level1);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game1level1.getUserGamePointsList().add(userGamePoints);
//        //user.getUserGamePointsList().add(userGamePoints);
//        //usersRepository.save(user);
        this.gameRepository.save(game1level1);


        // Игра 2
        Response response1G2L1 = new Response("сто и еден");
        Response response2G2L1 = new Response("сто и единаесет");
        Response response3G2L1 = new Response("петстотини");
        Response response4G2L1 = new Response("педесет и осум");

        this.responseRepository.save(response1G2L1);
        this.responseRepository.save(response2G2L1);
        this.responseRepository.save(response3G2L1);
        this.responseRepository.save(response4G2L1);

        List<Response> responseListG2L1 = new ArrayList<>(Arrays.asList(response1G2L1, response2G2L1, response3G2L1, response4G2L1));

        Question question1G2L1 = new Question("101", "", responseListG2L1, response1G2L1);
        Question question2G2L1 = new Question("58", "", responseListG2L1, response4G2L1);
        Question question3G2L1 = new Question("500", "", responseListG2L1, response3G2L1);

        this.questionRepository.save(question1G2L1);
        this.questionRepository.save(question2G2L1);
        this.questionRepository.save(question3G2L1);

        List<Question> questionListG2L1 = new ArrayList<>(Arrays.asList(question1G2L1, question2G2L1, question3G2L1));

        Game game2level1 = new Game("Погоди го бројот",
                "Играта се состои од дадени броеви. Ваша задача е да погодите како се пишува точно.",
                Level.Ниво1, "/images/number-game.jpg", 3,  questionListG2L1);

//        userGamePoints.setGame(game2level1);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game2level1.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game2level1);

        // Игра 3
        Response response1G3L1 = new Response("Црвена");
        Response response2G3L1 = new Response("Жолта");
        Response response3G3L1 = new Response("Зелена");
        Response response4G3L1 = new Response("Сина");

        this.responseRepository.save(response1G3L1);
        this.responseRepository.save(response2G3L1);
        this.responseRepository.save(response3G3L1);
        this.responseRepository.save(response4G3L1);

        List<Response> responseListG3L1 = new ArrayList<>(Arrays.asList(response1G3L1, response2G3L1, response3G3L1, response4G3L1));

        Question question1G3L1 = new Question("https://htmlcolorcodes.com/assets/images/colors/red-color-solid-background-1920x1080.png", "", responseListG3L1, response1G3L1);
        Question question2G3L1 = new Question("https://www.travelandleisure.com/thmb/KTIha5CLifSoUD3gx0YP51xc3rY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/blue0517-4dfc85cb0200460ab717b101ac07888f.jpg", "", responseListG3L1, response4G3L1);
        Question question3G3L1 = new Question("https://htmlcolorcodes.com/assets/images/colors/neon-green-color-solid-background-1920x1080.png", "", responseListG3L1, response3G3L1);

        this.questionRepository.save(question1G3L1);
        this.questionRepository.save(question2G3L1);
        this.questionRepository.save(question3G3L1);

        List<Question> questionListG3L1 = new ArrayList<>(Arrays.asList(question1G3L1, question2G3L1, question3G3L1));

        Game game3level1 = new Game("Погоди ја бојата",
                "Играта се состои од неколку слики со бои. Можете ли да погодите за коjа боја станува збор?",
                Level.Ниво1, "/images/color.jpg", 3, questionListG3L1);

//        userGamePoints.setGame(game3level1);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game3level1.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game3level1);


        /* --------------------------НИВО 2--------------------------------- */

        // Игра 1
        Response response1G1L2 = new Response("4");
        Response response2G1L2 = new Response("20");
        Response response3G1L2 = new Response("0");
        Response response4G1L2 = new Response("1");

        this.responseRepository.save(response1G1L2);
        this.responseRepository.save(response2G1L2);
        this.responseRepository.save(response3G1L2);
        this.responseRepository.save(response4G1L2);

        List<Response> responseListG1L2 = new ArrayList<>(Arrays.asList(response1G1L2, response2G1L2, response3G1L2, response4G1L2));

        Question question1G1L2 = new Question("2 + 2 =", "", responseListG1L2, response1G1L2);
        Question question2G1L2 = new Question("10 * 2", "", responseListG1L2, response2G1L2);
        Question question3G1L2 = new Question("11 - 11 = ", "", responseListG1L2, response3G1L2);

        this.questionRepository.save(question1G1L2);
        this.questionRepository.save(question2G1L2);
        this.questionRepository.save(question3G1L2);

        List<Question> questionListG1L2 = new ArrayList<>(Arrays.asList(question1G1L2, question2G1L2, question3G1L2));

        Game game1level2 = new Game("Реши го математичкиот израз",
                "Играта се состои од неколку математички изрази кои од вас се бара да ги решите.",
                Level.Ниво2, "/images/mathGame.jpg", 6, questionListG1L2);

//        userGamePoints.setGame(game1level2);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game1level2.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game1level2);

        // Игра 2
        Response response1G2L2 = new Response("15");
        Response response2G2L2 = new Response("5");
        Response response3G2L2 = new Response("0");
        Response response4G2L2 = new Response("12");

        this.responseRepository.save(response1G2L2);
        this.responseRepository.save(response2G2L2);
        this.responseRepository.save(response3G2L2);
        this.responseRepository.save(response4G2L2);

        List<Response> responseListG2L2 = new ArrayList<>(Arrays.asList(
                response1G2L2,
                response2G2L2,
                response3G2L2,
                response4G2L2));

        Question question1G2L2 = new Question("2 + _ = 7", "", responseListG2L2, response2G2L2);
        Question question2G2L2 = new Question("_ * 2 = 30", "", responseListG2L2, response1G2L2);
        Question question3G2L2 = new Question("55 - _ = 43", "", responseListG2L2, response4G2L2);

        this.questionRepository.save(question1G2L2);
        this.questionRepository.save(question2G2L2);
        this.questionRepository.save(question3G2L2);

        List<Question> questionListG2L2 = new ArrayList<>(Arrays.asList(question1G2L2, question2G2L2, question3G2L2));

        Game game2level2 = new Game("Добиј го точниот резултат",
                "Играта се состои од неколку математички изрази во кои недостасува некој број. Пронајдете го.",
                Level.Ниво2, "/images/missingNumber.jpg", 6, questionListG2L2);

//        userGamePoints.setGame(game2level2);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game2level2.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game2level2);

        // Игра 3
        Response response1G3L2 = new Response("2 + 2");
        Response response2G3L2 = new Response("10 + 3");
        Response response3G3L2 = new Response("20 - 5");
        Response response4G3L2 = new Response("12 - 1");

        this.responseRepository.save(response1G3L2);
        this.responseRepository.save(response2G3L2);
        this.responseRepository.save(response3G3L2);
        this.responseRepository.save(response4G3L2);

        List<Response> responseListG3L2 = new ArrayList<>(Arrays.asList(response1G3L2, response2G3L2, response3G3L2, response4G3L2));

        Question question1G3L2 = new Question("__ _ __ = 4", "", responseListG3L2, response1G3L2);
        Question question2G3L2 = new Question("__ _ __ = 15", "", responseListG3L2, response3G3L2);
        Question question3G3L2 = new Question("__ _ __ = 13", "", responseListG3L2, response2G3L2);

        this.questionRepository.save(question1G3L2);
        this.questionRepository.save(question2G3L2);
        this.questionRepository.save(question3G3L2);

        List<Question> questionListG3L2 = new ArrayList<>(Arrays.asList(question1G3L2, question2G3L2, question3G3L2));

        Game game3level2 = new Game("Погоди го изразот", "Играта се состои од даден резултат за кој вие треба да го погодите соодветниот израз.",
                Level.Ниво2, "/images/single-digit-subtraction-big.png", 6, questionListG3L2);

//        userGamePoints.setGame(game3level2);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game3level2.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game3level2);


        /* --------------------------НИВО 3--------------------------------- */

        //Игра 1

        Response response1G1L3 = new Response("+");
        Response response2G1L3 = new Response("-");
        Response response3G1L3 = new Response("*");
        Response response4G1L3 = new Response("/");

        this.responseRepository.save(response1G1L3);
        this.responseRepository.save(response2G1L3);
        this.responseRepository.save(response3G1L3);
        this.responseRepository.save(response4G1L3);

        List<Response> responseListG1L3 = new ArrayList<>(Arrays.asList(response1G1L3, response2G1L3, response3G1L3, response4G1L3));

        Question question1G1L3 = new Question("2 _ 2 = 4", "", responseListG1L3, response1G1L3);
        Question question2G1L3 = new Question("13 _ 5 = 8", "", responseListG1L3, response2G1L3);
        Question question3G1L3 = new Question("3 _ 11 = 33", "", responseListG1L3, response3G1L3);

        this.questionRepository.save(question1G1L3);
        this.questionRepository.save(question2G1L3);
        this.questionRepository.save(question3G1L3);

        List<Question> questionListG1L3 = new ArrayList<>(Arrays.asList(question1G1L3, question2G1L3, question3G1L3));

        Game game1level3 = new Game("Погоди ја аритметичката операција",
                "Вашата задача е да погодите која е бараната аритметичка операција.",
                Level.Ниво3, "/images/Arithmetic-Operations.png", 9, questionListG1L3);

//        userGamePoints.setGame(game1level3);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game1level3.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game1level3);

        //Игра 2
        //Дамјан - Ниво 3-2: Одговори ги прашањата 2 (Ниво 3)
        Response response1G2L3 = new Response("црвена");
        Response response2G2L3 = new Response("црна");
        Response response3G2L3 = new Response("бела");
        Response response4G2L3 = new Response("портокалова");

        Response response1G2L3r1 = new Response("Пепелашка");
        Response response2G2L3r1 = new Response("Снежана");
        Response response3G2L3r1 = new Response("Гаргамел");
        Response response4G2L3r1 = new Response("Џери");

        this.responseRepository.save(response1G2L3);
        this.responseRepository.save(response2G2L3);
        this.responseRepository.save(response3G2L3);
        this.responseRepository.save(response4G2L3);

        this.responseRepository.save(response1G2L3r1);
        this.responseRepository.save(response2G2L3r1);
        this.responseRepository.save(response3G2L3r1);
        this.responseRepository.save(response4G2L3r1);

        List<Response> responseListG2L3 = new ArrayList<>(Arrays.asList(response1G2L3, response2G2L3, response3G2L3, response4G2L3));
        List<Response> responseListG2L3r1 = new ArrayList<>(Arrays.asList(response1G2L3r1, response2G2L3r1, response3G2L3r1, response4G2L3r1));

        Question question1G2L3 = new Question("Каква боја е јаболкото?", "", responseListG2L3, response1G2L3);
        Question question2G2L3 = new Question("Каква боја е морковот?", "", responseListG2L3, response4G2L3);
        Question question3G2L3 = new Question("Како се вика принцезата кој заспала се додека нејзиниот принц" +
                " не ја бакнал?", "", responseListG2L3r1, response2G2L3r1);

        this.questionRepository.save(question1G2L3);
        this.questionRepository.save(question2G2L3);
        this.questionRepository.save(question3G2L3);

        List<Question> questionListG2L3 = new ArrayList<>(Arrays.asList(question1G2L3, question2G2L3, question3G2L3));

        Game game2level3 = new Game("Одговори ги прашањата",
                "Дадени се соодветни прашања. Ваша задача е да ги одговорите соодветните прашања.",
                Level.Ниво3, "/images/questions.png", 9, questionListG2L3);

//        userGamePoints.setGame(game2level3);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game2level3.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game2level3);

        //Игра 3
        Response response1G3L3 = new Response("Куќа");
        Response response2G3L3 = new Response("Маче");
        Response response3G3L3 = new Response("Книга");
        Response response4G3L3 = new Response("Куче");

        this.responseRepository.save(response1G3L3);
        this.responseRepository.save(response2G3L3);
        this.responseRepository.save(response3G3L3);
        this.responseRepository.save(response4G3L3);

        List<Response> responseListG3L3 = new ArrayList<>(Arrays.asList(response1G3L3, response2G3L3, response3G3L3, response4G3L3));


        Question question1G3L3 = new Question("https://static.vecteezy.com/system/resources/previews/006/325/639/original/dog-cartoon-colored-clipart-illustration-free-vector.jpg", "", responseListG3L3, response4G3L3);
        Question question2G3L3 = new Question("https://img.freepik.com/premium-vector/cartoon-funny-cat-sitting-white-background_29190-7708.jpg", "", responseListG3L3, response2G3L3);
        Question question3G3L3 = new Question("https://clipartix.com/wp-content/uploads/2016/05/Books-book-clipart-clipart-cliparts-for-you.jpg", "", responseListG3L3, response3G3L3);

        this.questionRepository.save(question1G3L3);
        this.questionRepository.save(question2G3L3);
        this.questionRepository.save(question3G3L3);

        List<Question> questionListG3L3 = new ArrayList<>(Arrays.asList(question1G3L3, question2G3L3, question3G3L3));

        Game game3level3 = new Game("Погоди што има на сликата",
                "Играта се состои од неколку слики. Можете ли да погодите што има на сликата?",
                Level.Ниво3, "/images/game_picture.jpg", 9, questionListG3L3);

//        userGamePoints.setGame(game3level3);
////        userGamePoints.setUser(user);
//        userGamePoints.setPoints(15);
//        game3level3.getUserGamePointsList().add(userGamePoints);
////        user.getUserGamePointsList().add(userGamePoints);
////        usersRepository.save(user);
        this.gameRepository.save(game3level3);
    }
}

package snake.client;

import com.codenjoy.dojo.client.Solver;
import com.codenjoy.dojo.client.WebSocketRunner;
import com.codenjoy.dojo.services.Direction;
import com.codenjoy.dojo.services.Point;

import java.util.List;

public class YourSolver implements Solver<Board> {

    Direction doSolve(Board board) {
        List<Point> barriers = board.getBarriers();
        List<Point> walls = board.getWalls();
        List<Point> snake = board.getSnake();
//        Direction snakeDirection = board.getSnakeDirection();
//        System.out.println("11111111111111111" + snakeDirection);
//        System.out.println("22222222222222222" + board.getHead());
        Point apple = board.getApples().get(0);
        Point head = board.getHead();
        System.out.println("123" + board.getStones());
        System.out.println("2345" + board.getBarriers());

        for (Point barrier : board.getBarriers()) {
//            if (apple.getX() < head.getX() && barrier.getX() != (head.getX() + 1)) return Direction.LEFT;
//            else if (apple.getX() > head.getX() && barrier.getX() != (head.getX() - 1)) return Direction.RIGHT;
//            else if (apple.getY() > head.getY() && barrier.getY() != (head.getY() - 1)) return Direction.UP;
                            if (apple.getX() < head.getX()) return Direction.LEFT;
            else if (apple.getX() > head.getX()) return Direction.RIGHT;
            else if (apple.getY() > head.getY()) return Direction.UP;
            else return Direction.DOWN;
        }
        return null;
    }

    @Override
    public String get(Board board) {
        return doSolve(board).toString();
    }

    public static void main(String[] args) {
        String url = "http://138.197.189.109/codenjoy-contest/board/player/jbgftw1jfchhvph1xyd3?code=639145208648732280";

        WebSocketRunner.runClient(
                url,
                new YourSolver(),
                new Board());
    }

}

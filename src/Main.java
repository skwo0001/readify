import java.util.Scanner;

public class Main {

    public static void main(String [] args) {

        Robot robot = new Robot();
        Boolean valid = false;
        Scanner scanner = new Scanner(System.in); //using scanner to read the input
        System.out.println("Enter command : ");

        while (scanner.hasNext()){
            String command = scanner.nextLine().toUpperCase().trim(); //read input
            if (valid == false && command.indexOf("PLACE") == 0) { //Place command only able to use when the validation of command is not work yet
                try {
                    String position = command.split(" ")[1]; //identify the position of robot
                    int x = Integer.parseInt(position.split(",")[0]);
                    int y = Integer.parseInt(position.split(",")[1]);
                    if (x > 0 || x < 4 || y > 0 || y < 4) { //the coordinate of X and Y are only allow in the digit between 0 to 4
                        String d = position.split(",")[2];
                        if (d.equals("EAST") || d.equals("WEST") || d.equals("SOUTH") || d.equals("NORTH")) { // the direcrtion can only be north, east, south and west
                            robot.setX(x);
                            robot.setY(y);
                            robot.setD(d);
                            System.out.println("Robot is allocated!"); //show msg to notice user, robot is allocated
                            valid = true; //once the robot allocated, the game can be started

                        }
                    }
                } catch (Exception e) {

                    //to prevent any error occur if the command is not match to the required pattern
                }
            } else if (valid == true){

                //once the robot allocated, get the value from robot
                int x = robot.getX();
                int y = robot.getY();
                String d = robot.getD();

                switch (command) { //read the command whether it is "MOVE", "LEFT", "RIGHT", "REPORT" or some invalid command
                    case "MOVE":
                        switch (d) {
                            case "EAST":
                                x += 1;
                                if (x < 5) {
                                    robot.setX(x);
                                }
                                break;
                            case "SOUTH":
                                y -= 1;
                                if (y > 0) {
                                    robot.setY(y);
                                }
                                break;
                            case "WEST":
                                x -= 1;
                                if (x > 0) {
                                    robot.setX(x);
                                }
                                break;
                            case "NORTH":
                                y += 1;
                                if (y < 5) {
                                    robot.setY(y);
                                }
                                break;
                            default:
                        }
                        break;
                        case "LEFT":
                            switch (d) {
                                case "EAST":
                                    robot.setD("NORTH");
                                    break;
                                case "SOUTH":
                                    robot.setD("EAST");
                                    break;
                                case "WEST":
                                    robot.setD("SOUTH");
                                    break;
                                case "NORTH":
                                    robot.setD("WEST");
                                    break;
                                default:
                            }
                            break;
                        case "RIGHT":
                            switch (d) {
                                case "EAST":
                                    robot.setD("SOUTH");
                                    break;
                                case "SOUTH":
                                    robot.setD("WEST");
                                    break;
                                case "WEST":
                                    robot.setD("NORTH");
                                    break;
                                case "NORTH":
                                    robot.setD("EAST");
                                    break;
                                default:
                            }
                            break;
                        case "REPORT":
                            System.out.println("Output: " + robot.getX() + "," + robot.getY() + "," + robot.getD());
                            System.exit(0);
                            break;
                        default:
                        }
            }
        }

    }
}


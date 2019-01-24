import java.util.Scanner;

public class RegularRobot extends Robot{

    @Override
    void move(){
        try {

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter start parameter x:");
            this.setX(Long.parseLong(scan.nextLine()));

            System.out.println("Enter start parameter y:");
            this.setY(Long.parseLong(scan.nextLine()));

            System.out.println("Enter start parameter direction:");
            this.setDirection(scan.nextLine().toUpperCase());
            if (!this.getDirection().equals("EAST") && !this.getDirection().equals("WEST") &&
                    !this.getDirection().equals("NORTH") && !this.getDirection().equals("SOUTH")) {
                throw new IllegalArgumentException("Invalid Direction");
            }

            boolean flag = true;
            String operations = null;
            char[] opArr = null;

            while(flag){
                System.out.println("Enter a sequence of operations (R - turn right; L - turn left; A - advance; X - exit simulation");
                operations = scan.nextLine().toUpperCase();
                opArr = operations.toCharArray();

                for (int i = 0; i < opArr.length; i++) {
                    if(opArr[i]=='R'){
                        if(this.getDirection().equals("EAST")) this.setDirection("SOUTH");
                        else if(this.getDirection().equals("SOUTH")) this.setDirection("WEST");
                        else if(this.getDirection().equals("WEST")) this.setDirection("NORTH");
                        else if(this.getDirection().equals("NORTH")) this.setDirection("EAST");
                    }

                    else if(opArr[i]=='L'){
                        if(this.getDirection().equals("EAST")) this.setDirection("NORTH");
                        else if(this.getDirection().equals("NORTH")) this.setDirection("WEST");
                        else if(this.getDirection().equals("WEST")) this.setDirection("SOUTH");
                        else if(this.getDirection().equals("SOUTH")) this.setDirection("EAST");
                    }

                    else if(opArr[i]=='A'){
                        if(this.getDirection().equals("EAST")) this.setX(this.getX()+1);
                        else if(this.getDirection().equals("WEST")) this.setX(this.getX()-1);
                        else if(this.getDirection().equals("NORTH")) this.setY(this.getY()+1);
                        else if(this.getDirection().equals("SOUTH")) this.setY(this.getY()-1);
                    }

                    else if(opArr[i]=='X'){
                        flag=false;
                        System.out.println("Final location:");
                    }

                    else{
                        System.out.println("Invalid Operation");
                    }

                    System.out.println("X: " + this.getX() + "; Y: " + this.getY() + "; Direction: " + this.getDirection());
                }
            }


        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();

        }catch(Exception e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }
    }
}

public class NBody{

    public static String imageToDraw = "images/starfield.jpg";

    public static double readRadius(String name){
        In in = new In(name);
        in.readInt();
        return in.readDouble();
    }
    public static Planet[] readPlanets(String name){
        In in = new In(name);
        int num=in.readInt();
        Planet[] Planets=new Planet [num];
        in.readDouble();
        for (int i=0;i<num;i++){
            double xP=in.readDouble();
            double yP=in.readDouble();
            double xV=in.readDouble();
            double yV=in.readDouble();
            double m=in.readDouble();
            String img="images/"+in.readString();
            Planets[i]=new Planet(xP, yP, xV, yV, m, img);
        }
        return Planets;
    }
    public static void main(String args[]){
        double time=0;
        String a=args[0];
        String b=args[1];
        Double T=Double.parseDouble(a);
        Double dt=Double.parseDouble(b);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        int num=planets.length;
    
    
        StdDraw.setScale(-radius, radius);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
		
        
        for (Planet p : planets){
            p.draw();
        }
        
        StdDraw.enableDoubleBuffering();
        while (time<T) {
            double[] xForces =new double[num];
            double[] yForces =new double[num];
            for (int j=0;j<num;j++){
                xForces[j]=planets[j].calcNetForceExertedByX(planets);
                yForces[j]=planets[j].calcNetForceExertedByY(planets);
                planets[j].update(dt, xForces[j], yForces[j]);
            }
            for (int j=0;j<num;j++){
                planets[j].update(dt, xForces[j], yForces[j]);
            }
            
            
            StdDraw.picture(0,0,imageToDraw);
            for (Planet p : planets){
                p.draw();
            }
            
            StdDraw.show();
            StdDraw.pause(10);
            T+=dt;


        }
		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
}
    }

    
}
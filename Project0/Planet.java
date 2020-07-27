public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G= 6.67e-11;
    
    public Planet(double xP, double yP, double xV,
              double yV, double m, String img){
            xxPos=xP;
            yyPos=yP;
            xxVel=xV;
            yyVel=yV;
            mass=m;
            imgFileName=img;
                
              }
    public Planet(Planet p) {
        xxPos=p.xxPos;
        yyPos=p.yyPos;
        xxVel=p.xxVel;
        yyVel=p.yyVel;
        mass=p.mass;
        imgFileName=p.imgFileName;
    }
   
    public double calcDistance(Planet c){
        double dx=this.xxPos-c.xxPos;
        double dy=this.yyPos-c.yyPos;
        double distance=Math.sqrt(dx*dx+dy*dy);
        return distance;
    }

    public double calcForceExertedBy(Planet c){
        double distance=this.calcDistance(c);
        double F=G*this.mass*c.mass/Math.pow(distance, 2);
        return F;
    }

    public double calcForceExertedByX(Planet c) {
        double F=this.calcForceExertedBy(c);
        double Fx=F*(c.xxPos-this.xxPos)/this.calcDistance(c);
        return Fx;
    }

    public double calcForceExertedByY(Planet c) {
        double F=this.calcForceExertedBy(c);
        double Fy=F*(c.yyPos-this.yyPos)/this.calcDistance(c);
        return Fy;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
       
        double netFx =0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                netFx = netFx + this.calcForceExertedByX(p);
            }
        }
        return netFx;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
       
        double netFy =0;
        for (Planet p : allPlanets) {
            if (!this.equals(p)) {
                netFy= netFy + this.calcForceExertedByY(p);
            }
        }
        return netFy;
    }

    public void update(double time,double Fx,double Fy){
        double accX=Fx/mass;
        double accY=Fy/mass;
        xxVel=xxVel+time*accX;
        yyVel=yyVel+time*accY;
        xxPos=xxPos+time*xxVel;
        yyPos=yyPos+time*yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos,yyPos,imgFileName);
    }
    
}
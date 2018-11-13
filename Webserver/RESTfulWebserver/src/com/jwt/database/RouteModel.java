package com.jwt.database;

public class RouteModel {
//	CREATE TABLE "route" (
//			  "id_route" serial PRIMARY KEY,
//			  "id_user" int,
//			  "name" varchar,
//			  "description" varchar,
//			  "startpoint" int,
//			  "endpoint" int
//			);
	public int id_user;
	public String name;
	public String description;
	public int startPoint;
	public int endPoint;
	
//	private DatabaseConnection connection = DatabaseConnection.getInstance(); 
	
	public RouteModel(int id_user, String name, String description, int startPoint, int endPoint) {
		this.id_user = id_user;
		this.name = name;
		this.description = description;
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
}

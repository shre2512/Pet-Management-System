/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author shrey
 */

public class databaseConnection {
    
    public Connection con;
    
    public databaseConnection()
    {
        try {
            this.con = createTables();
        } catch (Exception ex) {
            Logger.getLogger(databaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static Connection createTables() throws Exception{
        try{
            Connection con = getConnection();
            PreparedStatement create_usertable = con.prepareStatement("CREATE TABLE IF NOT EXISTS usertable(id int NOT NULL AUTO_INCREMENT, first_name VARCHAR(255), last_name VARCHAR(255), email_id VARCHAR(255), phone_number VARCHAR(255), user_name VARCHAR(255), password VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_petfood = con.prepareStatement("CREATE TABLE IF NOT EXISTS petfood(id int NOT NULL AUTO_INCREMENT, food_name VARCHAR(255), food_price int, available_quantity int, PRIMARY KEY(id))");
            PreparedStatement create_orders = con.prepareStatement("CREATE TABLE IF NOT EXISTS orders(id int NOT NULL AUTO_INCREMENT, user_id INT, product VARCHAR(255), order_total INT, item_type VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_pet_accessories = con.prepareStatement("CREATE TABLE IF NOT EXISTS petaccessories(id int NOT NULL AUTO_INCREMENT, accessory_name VARCHAR(255), accessory_price int, available_quantity int, PRIMARY KEY(id))");
            PreparedStatement create_grooming_appointments = con.prepareStatement("CREATE TABLE IF NOT EXISTS groomingappointments(id int NOT NULL AUTO_INCREMENT, user_id INT, service_name VARCHAR(255), service_cost VARCHAR(255), service_date VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_hospitals = con.prepareStatement("CREATE TABLE IF NOT EXISTS hospitals(id int NOT NULL AUTO_INCREMENT, city_name VARCHAR(255), community_name VARCHAR(255), hospital_name VARCHAR(255), hospital_zipcode VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_doctors = con.prepareStatement("CREATE TABLE IF NOT EXISTS doctors(id int NOT NULL AUTO_INCREMENT, first_name VARCHAR(255), last_name VARCHAR(255), email_ID VARCHAR(255), contact_number VARCHAR(255), hospital_name VARCHAR(255), username VARCHAR(255), password VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_kennelbooking = con.prepareStatement("CREATE TABLE IF NOT EXISTS kennelbooking(id int NOT NULL AUTO_INCREMENT,user_id INT, kennel_name VARCHAR(255), kennel_address VARCHAR(255), kennel_to VARCHAR(255),kennel_from VARCHAR(255),kennel_price_per_day INT,kennel_number_of_days INT, kennel_rent INT, kennel_pickup VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_kennel = con.prepareStatement("CREATE TABLE IF NOT EXISTS kennel(id int NOT NULL AUTO_INCREMENT, kennel_name VARCHAR(255), kennel_address VARCHAR(255), price_per_day int, PRIMARY KEY(id))");
            PreparedStatement create_encounter = con.prepareStatement("CREATE TABLE IF NOT EXISTS encounters(id int NOT NULL AUTO_INCREMENT, user_id INT, hospital_name VARCHAR(255), doctor_name VARCHAR(255), symptoms VARCHAR(255), encounter_date VARCHAR(255), PRIMARY KEY(id))");
            PreparedStatement create_open_orders_food = con.prepareStatement("CREATE TABLE IF NOT EXISTS openordersfood(id int NOT NULL AUTO_INCREMENT, product_id INT, order_quantity INT, PRIMARY KEY(id))");
            PreparedStatement create_open_orders_accessory = con.prepareStatement("CREATE TABLE IF NOT EXISTS openordersaccessory(id int NOT NULL AUTO_INCREMENT, product_id INT, order_quantity INT, PRIMARY KEY(id))");
            PreparedStatement create_closed_orders_food = con.prepareStatement("CREATE TABLE IF NOT EXISTS closedordersfood(id int NOT NULL AUTO_INCREMENT, product_name VARCHAR(255), ordered_quantity INT, PRIMARY KEY(id))");
            PreparedStatement create_closed_orders_accessory = con.prepareStatement("CREATE TABLE IF NOT EXISTS closedordersaccessory(id int NOT NULL AUTO_INCREMENT, product_name VARCHAR(255), ordered_quantity INT, PRIMARY KEY(id))");
            PreparedStatement create_vital_signs = con.prepareStatement("CREATE TABLE IF NOT EXISTS vitalsigns(id int NOT NULL AUTO_INCREMENT, encounter_id INT, encounter_date VARCHAR(255), symptoms VARCHAR(255), user_id INT, body_temp INT, respiration_rate INT, heart_rate INT, PRIMARY KEY(id))");
            
            create_kennelbooking.executeUpdate();
            create_kennel.executeUpdate();
            create_usertable.executeUpdate();
            create_petfood.executeUpdate();
            create_orders.executeUpdate();
            create_pet_accessories.executeUpdate();
            create_grooming_appointments.executeUpdate();
            create_hospitals.executeUpdate();
            create_doctors.executeUpdate();
            create_encounter.executeUpdate();
            create_open_orders_food.executeUpdate();
            create_open_orders_accessory.executeUpdate();
            create_closed_orders_food.executeUpdate();
            create_closed_orders_accessory.executeUpdate();
            create_vital_signs.executeUpdate();
            
            return con;
        } catch(Exception e){System.out.println(e);}
        finally{System.out.println("Table Created!");
        }
        return null;
    }
    
    private static Connection getConnection() throws Exception{
        try{

            Properties prop = new Properties();
            InputStream input = null;
            input = new FileInputStream("config.properties");
            prop.load(input);

            String username = prop.getProperty("dbUserName");
            String password = prop.getProperty("dbPassword");

            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/aed_project";

            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url,username, password);
            System.out.println("Connected");
            return conn;
           } catch(Exception e){System.out.println(e);}

            return null;
    } 
    
    public ResultSet executeSelect(String query) throws Exception
    {
        PreparedStatement select = con.prepareStatement(query);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public void executeInsert(String query) throws Exception
    {
        PreparedStatement insert = con.prepareStatement(query);
        insert.executeUpdate();
    }
    
    public void executePetFoodUpdate(String query, int quantity, String foodName) throws Exception
    {
        PreparedStatement updateQty = con.prepareStatement(query);
        updateQty.setInt(1,quantity);
        updateQty.setString(2,foodName);
        updateQty.executeUpdate();   
    }
    
    public void executePetAccessoryUpdate(String query, int quantity, String accessoryName) throws Exception
    {
        PreparedStatement updateQty = con.prepareStatement(query);
        updateQty.setInt(1,quantity);
        updateQty.setString(2,accessoryName);
        updateQty.executeUpdate();   
    }
    
    public void executePetFoodUpdate(String query, int foodPrice, int id) throws Exception
    {
        PreparedStatement updateQty = con.prepareStatement(query);
        updateQty.setInt(1,foodPrice);
        updateQty.setInt(2, id);
        updateQty.executeUpdate();   
    }
    
    public void insertOrderItem(int userId, int applawsOrderPrice, int pedigreeOrderPrice, int naturalsOrderPrice, int tikiCatOrderPrice) throws Exception
    {        
        if(applawsOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Applaws");
            insertOrder.setInt(3, applawsOrderPrice);
            insertOrder.setString(4, "Food");
            insertOrder.executeUpdate();
        }
        
        if(pedigreeOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Pedigree");
            insertOrder.setInt(3, pedigreeOrderPrice);
            insertOrder.setString(4, "Food");
            insertOrder.executeUpdate();
        }
                
        if(naturalsOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Naturals");
            insertOrder.setInt(3, naturalsOrderPrice);
            insertOrder.setString(4, "Food");
            insertOrder.executeUpdate();
        }
        
        if(tikiCatOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Tiki Cat");
            insertOrder.setInt(3, tikiCatOrderPrice);
            insertOrder.setString(4, "Food");
            insertOrder.executeUpdate();
        }  
    }
    
    public void insertOrderItemA(int userId, int latexToysOrderPrice, int chuckitOrderPrice, int nylaboneOrderPrice, int collarNecklacePrice) throws Exception
    {        
        if(latexToysOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Latex Toys");
            insertOrder.setInt(3, latexToysOrderPrice);
            insertOrder.setString(4, "Accessory");
            insertOrder.executeUpdate();
        }
        
        if(chuckitOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Chuckit");
            insertOrder.setInt(3, chuckitOrderPrice);
            insertOrder.setString(4, "Accessory");
            insertOrder.executeUpdate();
        }
                
        if(nylaboneOrderPrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Nylabone");
            insertOrder.setInt(3, nylaboneOrderPrice);
            insertOrder.setString(4, "Accessory");
            insertOrder.executeUpdate();
        }
        
        if(collarNecklacePrice != 0)
        {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO orders (user_id, product, order_total, item_type) VALUES (?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, "Collar Necklace");
            insertOrder.setInt(3, collarNecklacePrice);
            insertOrder.setString(4, "Accessory");
            insertOrder.executeUpdate();
        }  
    }
    
    
    public ResultSet executeSelect(int userID) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT item_type, product, SUM(order_total) as total_user_orders FROM orders WHERE user_id = ? GROUP BY item_type, product");
        select.setInt(1, userID);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public void insertHospitals(String city_name, String community_name, String hospital_name, String hospital_zipcode) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO hospitals (city_name, community_name, hospital_name, hospital_zipcode) VALUES (?, ?, ?, ?)");
        insertOrder.setString(1, city_name);
        insertOrder.setString(2, community_name);
        insertOrder.setString(3, hospital_name);
        insertOrder.setString(4, hospital_zipcode);
        insertOrder.executeUpdate();
    }
    
    public void insertDoctors(String first_name, String last_name, String email_ID, String contact_number, String hospital_name, String username, String password) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO doctors(first_name, last_name, email_ID, contact_number, hospital_name, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)");
        insertOrder.setString(1, first_name);
        insertOrder.setString(2, last_name);
        insertOrder.setString(3, email_ID);
        insertOrder.setString(4, contact_number);
        insertOrder.setString(5, hospital_name);
        insertOrder.setString(6, username);
        insertOrder.setString(7, password);
        insertOrder.executeUpdate();
    }
    
    public void insertKennelBooking(int userId, String name, String address, String toDate, String fromDate, int pricePerDay, int numberOfDays, int rent,String pickup) throws Exception
    {
            PreparedStatement insertOrder = con.prepareStatement("INSERT INTO kennelbooking (user_id, kennel_name, kennel_address, kennel_to, kennel_from,kennel_price_per_day, kennel_number_of_days, kennel_rent, kennel_pickup) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            insertOrder.setInt(1, userId);
            insertOrder.setString(2, name);
            insertOrder.setString(3, address);
            insertOrder.setString(4, toDate);
            insertOrder.setString(5, fromDate);
            insertOrder.setInt(6, pricePerDay);
            insertOrder.setInt(7, numberOfDays);
            insertOrder.setInt(8, rent);
            insertOrder.setString(9, pickup);
            insertOrder.executeUpdate();
        }
    
    public void executeKennelPriceUpdate(String query, int price_per_day, int id) throws Exception
    {
        PreparedStatement updateQty = con.prepareStatement(query);
        updateQty.setInt(1,price_per_day);
        updateQty.setInt(2,id);
        updateQty.executeUpdate();   
    }
    
    public ResultSet executeSelectKennel(String kennel_name) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT price_per_day FROM kennel WHERE kennel_name = ?");
        select.setString(1, kennel_name);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public ResultSet executeSelectDoctors(String hospital_name) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT * FROM doctors WHERE hospital_name = ?");
        select.setString(1, hospital_name);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public void executeInsertEncounter(int userID, String hospital_name, String doctor_name, String symptoms, String encounter_date) throws Exception
    {
        PreparedStatement insertEncounter = con.prepareStatement("INSERT INTO encounters(user_id, hospital_name, doctor_name, symptoms, encounter_date) VALUES (?, ?, ?, ?, ?)");
        insertEncounter.setInt(1, userID);
        insertEncounter.setString(2, hospital_name);
        insertEncounter.setString(3, doctor_name);
        insertEncounter.setString(4, symptoms);
        insertEncounter.setString(5, encounter_date);
        insertEncounter.executeUpdate();
    }
    
    public void insertOpenOrdersFood(int product_id, int order_quantity) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO openordersfood(product_id, order_quantity) VALUES (?, ?)");
        insertOrder.setInt(1, product_id);
        insertOrder.setInt(2, order_quantity);
        insertOrder.executeUpdate();
    }
    
    public void insertOpenOrdersAccessory(int product_id, int order_quantity) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO openordersaccessory(product_id, order_quantity) VALUES (?, ?)");
        insertOrder.setInt(1, product_id);
        insertOrder.setInt(2, order_quantity);
        insertOrder.executeUpdate();
    }
    
    public ResultSet executeFoodNameSelect(int foodId) throws Exception
    {
        PreparedStatement selectFoodName = con.prepareStatement("SELECT food_name FROM petfood WHERE id = ?");
        selectFoodName.setInt(1, foodId);
        ResultSet result = selectFoodName.executeQuery();
        return result;
    }
    
    public void insertClosedOrdersFood(String productName, int orderedQuantity) throws Exception
    {
        PreparedStatement insertClosedOrder = con.prepareStatement("INSERT INTO closedordersfood(product_name, ordered_quantity) VALUES (?, ?)");
        insertClosedOrder.setString(1, productName);
        insertClosedOrder.setInt(2, orderedQuantity);
        insertClosedOrder.executeUpdate();
    }
    
    public void deleteOpenOrdersFood(int orderID) throws Exception
    {
        PreparedStatement insertClosedOrder = con.prepareStatement("DELETE FROM openordersfood WHERE id = ?");
        insertClosedOrder.setInt(1, orderID);
        insertClosedOrder.executeUpdate();
    }
    
    public void updatePetFood(String productName, int orderedQuantity) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT id FROM petfood WHERE food_name = ?");
        select.setString(1, productName);
        ResultSet result = select.executeQuery();
        int orderID = -1;
        
        while(result.next())
        {
            orderID = result.getInt("id");
        }
        if(orderID != -1)
        {
            PreparedStatement update = con.prepareStatement("UPDATE petfood SET available_quantity = available_quantity + ? WHERE id = ?");
            update.setInt(1, orderedQuantity);
            update.setInt(2, orderID);
            update.executeUpdate();
        }
    }
    
    public ResultSet executeAccessoryNameSelect(int accesoryID) throws Exception
    {
        PreparedStatement selectAccessoryName = con.prepareStatement("SELECT accessory_name FROM petaccessories WHERE id = ?");
        selectAccessoryName.setInt(1, accesoryID);
        ResultSet result = selectAccessoryName.executeQuery();
        return result;
    }
    
    public void insertClosedOrdersAccessory(String productName, int orderedQuantity) throws Exception
    {
        PreparedStatement insertClosedOrder = con.prepareStatement("INSERT INTO closedordersaccessory(product_name, ordered_quantity) VALUES (?, ?)");
        insertClosedOrder.setString(1, productName);
        insertClosedOrder.setInt(2, orderedQuantity);
        insertClosedOrder.executeUpdate();
    }
    
    public void deleteOpenOrdersAccessory(int orderID) throws Exception
    {
        PreparedStatement insertClosedOrder = con.prepareStatement("DELETE FROM openordersaccessory WHERE id = ?");
        insertClosedOrder.setInt(1, orderID);
        insertClosedOrder.executeUpdate();
    }
    
    public void updatePetAccessories(String productName, int orderedQuantity) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT id FROM petaccessories WHERE accessory_name = ?");
        select.setString(1, productName);
        ResultSet result = select.executeQuery();
        int orderID = -1;
        
        while(result.next())
        {
            orderID = result.getInt("id");
        }
        if(orderID != -1)
        {
            PreparedStatement update = con.prepareStatement("UPDATE petaccessories SET available_quantity = available_quantity + ? WHERE id = ?");
            update.setInt(1, orderedQuantity);
            update.setInt(2, orderID);
            update.executeUpdate();
        }
    }
    
    public ResultSet getDoctorEncounters(String fullName) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT * FROM encounters WHERE doctor_name = ?");
        select.setString(1, fullName);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public int getUserID(int encounterID) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT user_id FROM encounters WHERE id = ?");
        select.setInt(1, encounterID);
        ResultSet result = select.executeQuery();
        int userID = -1;
        while(result.next())
        {
            userID = result.getInt("user_id");
        }
        return userID;
    }
    
    public void insertVitalSigns(int encounterID, String encounterDate, String symptoms, int userID, int bodyTemp, int respirationRate, int heartRate) throws Exception
    {
        PreparedStatement vitalSigns = con.prepareStatement("INSERT INTO vitalsigns(encounter_id, encounter_date, symptoms, user_id, body_temp, respiration_rate, heart_rate) VALUES (?, ?, ?, ?, ?, ?, ?)");
        vitalSigns.setInt(1, encounterID);
        vitalSigns.setString(2, encounterDate);
        vitalSigns.setString(3, symptoms);
        vitalSigns.setInt(4, userID);
        vitalSigns.setInt(5, bodyTemp);
        vitalSigns.setInt(6, respirationRate);
        vitalSigns.setInt(7, heartRate);
        vitalSigns.executeUpdate();
    }
    
    public ResultSet getPastVitalSigns(int userID) throws Exception
    {
        PreparedStatement getPastVitals = con.prepareStatement("SELECT * FROM vitalsigns WHERE user_id = ?");
        getPastVitals.setInt(1, userID);
        ResultSet result = getPastVitals.executeQuery();
        return result;
    }
    
    public ResultSet getPastGroomingServices(int userID) throws Exception
    {
        PreparedStatement select = con.prepareStatement("SELECT service_name, SUM(service_cost) as total_grooming_spend FROM groomingappointments WHERE user_id = ? GROUP BY service_name");
        select.setInt(1, userID);
        ResultSet result = select.executeQuery();
        return result;
    }
    
    public void executeGroomingServicePriceUpdate(String query, int newPrice, int serviceID) throws Exception
    {
        PreparedStatement update = con.prepareStatement(query);
        update.setInt(1, newPrice);
        update.setInt(2, serviceID);
        update.executeUpdate();
    }
    
    public void insertGroomingService(String serviceName, String serviceTime, int serviceCost) throws Exception
    {
        PreparedStatement insert = con.prepareStatement("INSERT INTO groomingservices(service_name, service_time, service_cost) VALUES(?, ?, ?)");
        insert.setString(1, serviceName);
        insert.setString(2, serviceTime);
        insert.setInt(3, serviceCost);
        insert.executeUpdate();
    }
    
    public void insertPetsIntoShelter(String petId, String name, String dob, int Age, String gender, String type, int height,int weight,String vaccine, byte[] image) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO shelterPets (pet_id, pet_name, pet_date_of_birth, pet_age, pet_gender,pet_type,pet_height, pet_weight, pet_vaccination_status, pet_image) VALUES (?, ?, ?, ?,?,?,?,?,?,?)");
        insertOrder.setString(1, petId);
        insertOrder.setString(2, name);
        insertOrder.setString(3, dob);
        insertOrder.setInt(4, Age);
        insertOrder.setString(5, gender);
        insertOrder.setString(6, type);
        insertOrder.setInt(7, height);
        insertOrder.setInt(8, weight);
        insertOrder.setString(9, vaccine);
        insertOrder.setBytes(10, image);
        insertOrder.executeUpdate();
    }
        
    public void adoptedPets(String petId,int userId, String name) throws Exception
    {
        PreparedStatement insertOrder = con.prepareStatement("INSERT INTO adoptedPets (pet_id,user_id, pet_name) VALUES (?,?, ?)");
        insertOrder.setString(1, petId);
        insertOrder.setInt(2, userId);
        insertOrder.setString(3, name);
        insertOrder.executeUpdate();
    }
    
    public void deleteFromShelter(int ID) throws Exception
    {
        PreparedStatement insertClosedOrder = con.prepareStatement("DELETE FROM shelterPets WHERE id = ?");
        insertClosedOrder.setInt(1, ID);
        insertClosedOrder.executeUpdate();
    }
}

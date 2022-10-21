package conexionbd;

import java.sql.*;

public class conexionBD {

    private static String servidor = "jdbc:mysql://dns11036.phdns11.es";
    private static Connection connection;
    private static Statement st = null;

    public static void main(String[] args) throws SQLException {
        crearConexion();
        String[] campos = {"ID int Primary Key AUTO_INCREMENT", "nombre varchar(25)", "apellidos varchar(25)", "edad int"};
        //crearTabla("cmartin", campos);
        //insertarDatos();
        st = connection.createStatement();
        //ordenarEdad();
        //ordenarApellidos();
        //mayores30();
        //nombresJ();
        //nombresCapellidosA();
        //mediaEdad();
        //apellidosOH();
        //franjaEdad();
        mayores65();
    }

    public static void crearConexion() {
        connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(servidor, "ad2223", "nervion");
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void crearTabla(String tabla, String[] campos) {
        String sql = "CREATE TABLE ad2223." + tabla + " (";
        for (int i = 0; i < campos.length; i++) {
            sql += campos[i];
            if (i < campos.length - 1) {
                sql += ",";
            }
        }
        sql += " );";

        System.out.println(sql);

        try {
            st = connection.createStatement();
            st.executeUpdate(sql);
            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertarDatos() {
        String[] datos = {"insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (1, 'Bruce', 'Semble', 89);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (2, 'Callie', 'Kobelt', 85);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (3, 'Rafe', 'Bailiss', 35);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (4, 'Sally', 'Batchan', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (5, 'Tracy', 'Climpson', 57);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (6, 'Ottilie', 'Solano', 81);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (7, 'Janis', 'Raven', 69);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (8, 'Bastien', 'Vernazza', 72);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (9, 'Abra', 'Osichev', 13);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (10, 'Bentlee', 'Aisman', 74);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (11, 'Georgetta', 'Skipping', 50);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (12, 'Ariel', 'Crassweller', 80);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (13, 'Lu', 'Cossem', 45);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (14, 'Agace', 'Diffley', 66);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (15, 'Nathanil', 'Mitroshinov', 78);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (16, 'Raquela', 'Varden', 44);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (17, 'Miran', 'Rahill', 49);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (18, 'Kippy', 'Grouer', 89);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (19, 'Westbrook', 'Kasbye', 85);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (20, 'Madelle', 'Bernardeschi', 35);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (21, 'Olly', 'Cleveland', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (22, 'Bernete', 'Gheorghescu', 78);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (23, 'Meyer', 'Hurdidge', 33);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (24, 'Susan', 'Steljes', 73);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (25, 'Dionis', 'Holt', 61);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (26, 'Ely', 'Tuft', 85);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (27, 'Tammara', 'Mableson', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (28, 'Goldina', 'Hatfield', 63);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (29, 'Traver', 'Adamiak', 84);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (30, 'Lauralee', 'Power', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (31, 'Willdon', 'Jacqueminet', 62);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (32, 'Malynda', 'Caldroni', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (33, 'Claudia', 'Gaudin', 49);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (34, 'Lay', 'Fransseni', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (35, 'Bibbie', 'Marquis', 64);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (36, 'Bat', 'Mertin', 33);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (37, 'Kristina', 'Lawey', 60);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (38, 'Gareth', 'Esposita', 56);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (39, 'Perrine', 'Caghan', 67);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (40, 'Hubert', 'O''Doohaine', 20);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (41, 'Beltran', 'Owen', 71);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (42, 'Hillery', 'Heliet', 76);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (43, 'Lisle', 'Mallock', 56);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (44, 'Luz', 'McGriele', 84);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (45, 'Brant', 'Risso', 47);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (46, 'Cosette', 'Simoni', 57);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (47, 'Brade', 'Huckabe', 31);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (48, 'Zulema', 'Lamping', 50);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (49, 'Minda', 'Van Dalen', 66);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (50, 'Merle', 'Staines', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (51, 'Kissee', 'Jeandin', 38);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (52, 'Janka', 'Strongitharm', 70);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (53, 'Trenton', 'Killelea', 82);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (54, 'Celestyna', 'Dowsett', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (55, 'Gill', 'Quant', 81);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (56, 'Lishe', 'Lloyd-Williams', 13);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (57, 'Bing', 'Geerdts', 85);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (58, 'Samara', 'Decourcy', 75);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (59, 'Chelsae', 'Ahrenius', 48);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (60, 'Octavius', 'Vanshin', 46);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (61, 'Zara', 'Willbond', 99);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (62, 'Ileane', 'Fenty', 96);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (63, 'Myrah', 'Charlotte', 50);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (64, 'Sherilyn', 'Streatley', 73);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (65, 'Charline', 'Angove', 64);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (66, 'Dolph', 'Feasby', 22);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (67, 'Koressa', 'Chaulk', 71);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (68, 'Vera', 'Gasking', 58);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (69, 'Hyacinthe', 'Abrehart', 88);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (70, 'Cary', 'Klawi', 45);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (71, 'Stanislas', 'Kilbee', 94);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (72, 'Ealasaid', 'Kleeborn', 71);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (73, 'Stace', 'Hursey', 55);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (74, 'Cathrine', 'Nucator', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (75, 'Jase', 'Grigorkin', 60);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (76, 'Lucie', 'Cutmare', 58);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (77, 'Lorri', 'Boadby', 13);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (78, 'Merle', 'Chesterman', 89);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (79, 'Grayce', 'Ricardin', 33);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (80, 'Alan', 'Cadigan', 100);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (81, 'Trina', 'Victor', 24);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (82, 'Algernon', 'Vayne', 29);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (83, 'Brandice', 'Morton', 23);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (84, 'Natalina', 'Clifford', 57);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (85, 'Park', 'Pringer', 60);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (86, 'Kimberly', 'Boxill', 94);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (87, 'Ephrem', 'McGahey', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (88, 'Udale', 'Spry', 15);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (89, 'Salaidh', 'Vigors', 97);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (90, 'Leroy', 'Nester', 50);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (91, 'Carol', 'Gipps', 73);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (92, 'Kristal', 'Wollers', 56);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (93, 'Georgie', 'Atte-Stone', 74);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (94, 'Flinn', 'Dake', 48);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (95, 'Jeffrey', 'Jeram', 55);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (96, 'Rodd', 'Lintot', 36);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (97, 'Rae', 'Kacheller', 83);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (98, 'Allyn', 'Drinkhall', 48);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (99, 'Bonnie', 'Fassbender', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (100, 'Worth', 'Rentoul', 37);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (101, 'Cyrus', 'Cupitt', 84);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (102, 'Corrie', 'Millbank', 48);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (103, 'Christoffer', 'Sporton', 21);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (104, 'Hulda', 'Pawley', 62);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (105, 'Tim', 'Blankau', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (106, 'Zak', 'Facchini', 80);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (107, 'Thane', 'Bold', 61);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (108, 'Smitty', 'Capper', 30);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (109, 'Uri', 'Jotcham', 78);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (110, 'Rossie', 'Pierse', 60);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (111, 'Zondra', 'Phillins', 66);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (112, 'Kordula', 'Dannel', 82);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (113, 'Ryley', 'Eake', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (114, 'Dalt', 'Gain', 86);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (115, 'Cece', 'Muncey', 77);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (116, 'Sharla', 'Aleevy', 58);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (117, 'Denney', 'Senchenko', 99);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (118, 'Daisy', 'Jessep', 38);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (119, 'Beth', 'Gilvear', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (120, 'Marga', 'Antonich', 77);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (121, 'Karna', 'Donald', 54);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (122, 'Katha', 'Hatherley', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (123, 'Dev', 'O''Day', 87);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (124, 'Cicely', 'Benmore', 44);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (125, 'Terrance', 'De Vaan', 100);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (126, 'Calvin', 'Whitehouse', 73);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (127, 'Haskell', 'Crotch', 44);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (128, 'Tan', 'Pavis', 19);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (129, 'Harriette', 'Di Ruggero', 80);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (130, 'Astrid', 'Cribbott', 47);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (131, 'Yardley', 'Desaur', 37);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (132, 'Janela', 'Vittle', 92);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (133, 'Bearnard', 'Bragger', 17);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (134, 'Henrieta', 'Osment', 53);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (135, 'Raymond', 'Clampett', 45);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (136, 'Brigham', 'Hane', 20);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (137, 'Rina', 'Egarr', 70);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (138, 'Gusty', 'MacGruer', 74);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (139, 'Rebe', 'Castri', 14);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (140, 'Jeremy', 'Gregh', 72);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (141, 'Trumaine', 'Schuck', 34);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (142, 'Brandais', 'Kumar', 77);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (143, 'Roselle', 'Millmoe', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (144, 'Brinn', 'Heartfield', 44);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (145, 'Lizette', 'Fensome', 78);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (146, 'Othella', 'Coston', 52);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (147, 'Fabio', 'Chaney', 88);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (148, 'Anselm', 'Nyland', 79);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (149, 'Russ', 'Keemer', 30);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (150, 'Iormina', 'Espasa', 55);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (151, 'Ashien', 'Hartigan', 31);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (152, 'Cherianne', 'Warcup', 53);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (153, 'Jada', 'Cushe', 67);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (154, 'Cleve', 'Kenrack', 98);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (155, 'Rayna', 'Ghidetti', 89);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (156, 'Jada', 'Hindshaw', 23);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (157, 'Layla', 'Lieb', 36);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (158, 'Nikita', 'Gradley', 72);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (159, 'Elene', 'Eager', 84);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (160, 'Osgood', 'Trees', 64);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (161, 'Burg', 'Bransom', 82);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (162, 'Genvieve', 'Valti', 29);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (163, 'Lonnard', 'Southerton', 28);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (164, 'Harris', 'Rosenwasser', 29);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (165, 'Estrellita', 'Trappe', 87);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (166, 'Nobie', 'Cruikshanks', 85);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (167, 'Yehudit', 'Brangan', 49);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (168, 'Shirleen', 'Pallent', 23);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (169, 'Constancy', 'Habbergham', 40);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (170, 'Zandra', 'Chessel', 89);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (171, 'Shea', 'Everly', 77);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (172, 'Hester', 'Toffolo', 42);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (173, 'Far', 'Sebrook', 46);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (174, 'Howie', 'Caso', 62);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (175, 'Cele', 'Briscam', 82);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (176, 'Oliver', 'Scholte', 72);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (177, 'Ford', 'Priden', 41);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (178, 'Annabell', 'Danick', 32);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (179, 'Adelind', 'Busse', 94);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (180, 'Hermon', 'Mitchely', 66);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (181, 'Cristen', 'Jelfs', 68);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (182, 'Gene', 'Hallworth', 97);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (183, 'Mahalia', 'Ross', 98);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (184, 'Lian', 'McIntee', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (185, 'Tod', 'Bowser', 27);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (186, 'Lainey', 'Santorini', 66);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (187, 'Michaeline', 'Boulding', 51);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (188, 'Dionysus', 'Witter', 14);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (189, 'Gunter', 'Maywood', 88);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (190, 'Amara', 'Scammonden', 92);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (191, 'Yvette', 'Burl', 24);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (192, 'Morley', 'Quinion', 22);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (193, 'Reeba', 'Swettenham', 34);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (194, 'Mortimer', 'Sawkin', 39);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (195, 'Gabriel', 'Spurdle', 21);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (196, 'Brigida', 'Lawton', 30);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (197, 'Nanny', 'Dettmar', 45);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (198, 'Patricio', 'Morl', 62);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (199, 'Cherida', 'Sweedland', 42);",
                "insert into ad2223.cmartin (ID, nombre, apellidos, edad) values (200, 'Mikol', 'Eastope', 85);"};

        try {
            st = connection.createStatement();
            for (String sql: datos)
            {
                st.executeUpdate(sql);
            }

            st.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void mostrar(String sql) throws SQLException {
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            System.out.println(resultSet.getString("nombre")+"\t"+resultSet.getString("apellidos")+"\t"+resultSet.getString("edad"));
        }
    }

    private static void mostrarMedia(String sql) throws SQLException {
        ResultSet resultSet = st.executeQuery(sql);
        while (resultSet.next()){
            System.out.println("La media de edad es de "+ resultSet.getString("media"));
        }
    }

    //Listado ordenado por edad.
    public static void ordenarEdad() throws SQLException {
        String sql ="Select nombre, apellidos, edad From ad2223.cmartin ORDER BY edad";
        mostrar(sql);
    }

    //Listado de los nombres y apellidos ordenados por apellido.
    public static void ordenarApellidos() throws SQLException {
        String sql = "Select nombre, apellidos, edad From ad2223.cmartin ORDER BY apellidos";
        mostrar(sql);
    }

    //Listado de nombres y apellidos de más de 30 años
    public static void mayores30() throws SQLException {
        String sql = "Select * From ad2223.cmartin WHERE edad>30 ORDER BY edad";
        mostrar(sql);
    }

    //Listado de los nombres que comiencen por "J" ordenados por apellido.
    public static void nombresJ() throws SQLException {
        String sql = "Select * From ad2223.cmartin WHERE nombre LIKE 'J%' ORDER BY apellidos";
        mostrar(sql);
    }

    //Listado de los nombres que comiencen por "C" y los apellidos por "A" ordenados por edad de mayor a menor.
    public static void nombresCapellidosA() throws SQLException {
        String sql = "Select * From ad2223.cmartin WHERE nombre LIKE 'C%' and apellidos LIKE 'A%' ORDER BY edad DESC";
        mostrar(sql);
    }

    //Media de edad de la muestra.
    public static void mediaEdad() throws SQLException{
        String sql = "Select AVG (edad) as media From ad2223.cmartin";
        mostrarMedia(sql);
    }

    //Listado de los apellidos que contengan las letras "oh" o las letras "ma" (si el resultado fuera nulo, cambiar las letras)
    public static void apellidosOH() throws SQLException {
        String sql = "Select * From ad2223.cmartin WHERE apellidos LIKE '%oh%' OR apellidos LIKE '%ma%' ";
        mostrar(sql);
    }

    //Listado de las personas en la franja de edad comprendida entre los 24 y los 32 años.
    public static void franjaEdad() throws SQLException{
        String sql = "Select * From ad2223.cmartin WHERE edad BETWEEN 24 AND 32 ORDER BY edad ";
        mostrar(sql);
    }

    //Listado de las personas mayores de 65 años.
    public static void mayores65() throws SQLException{
        String sql = "Select * From ad2223.cmartin WHERE edad>65 ORDER BY edad ";
        mostrar(sql);
    }

    //Crea una columna denominada "laboral" que contendrá los siguientes valores: estudiante, ocupado, parado, jubilado.

}

-- 1. Yukarıdaki tabloların create scriptlerini oluşturunuz

-- Country: id, name

CREATE TABLE Country(id INT PRIMARY KEY,
					name VARCHAR(50) NOT NULL)

-- Lig: id, adı, id_country(hangi ülkenin ligi)
CREATE TABLE League (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50),
    country_id INT)
				 
-- Takim: id, adı, id_leauge, kuruluş yılı, attığı gol, yediği gol, puan, seviye(1=en üst lig, 2, onun bir alt ligi gibi)

CREATE TABLE Team(id INT PRIMARY KEY,
				  name VARCHAR(50),
				  id_leauge INT ,
				  establishment_year INT,
				  goals_scored INT,
				  goals_conceded INT,
				  points INT,
				  level INT)
				  
-- Oyuncu: id, adı, soyadı, id_team, id_country(nereli), attığı gol
CREATE TABLE Player(id INT PRIMARY KEY,
				   name VARCHAR(30),
				   surname VARCHAR(30),
				   id_team INT,
				   id_country VARCHAR(50),
					goals_scored INT)
					
					

-- Bu tabloları dolduran insert scriptler yazınız. Ligi olmayan takım

INSERT INTO Country (id ,name) VALUES
(1,'Turkey'),
(2,'England'),
(3,'France'),
(4,'Brazil'),
(5,'Argentina')



INSERT INTO League (id , name, country_id) VALUES
(1,'Super Lig', 1),
(2,'Premier League', 2),
(3,'Ligue 1', 3),
(4,'Campeonato Brasileiro Série A', 4),
(5,'Serie A', 5)


INSERT INTO Team(id, name,id_leauge, establishment_year, goals_scored ,goals_conceded ,points ,level ) VALUES
(1 ,'Galatasaray', 1, 1905, 60, 30, 75, 1),
(2 ,'Manchester City', 2, 1880, 85, 25, 88, 1),
(3 ,'Paris Saint-Germain', 3, 1970, 70, 30, 82, 1),
(4 ,'AC Milan', 5, 1899, 60, 40, 72, 1),
(5 ,'Palmeiras', 4, 1914, 50, 35, 70, 1),
(6 ,'Liverpool', 2, 1892, 75, 20, 80, 1)
(7 ,'x', 2, 1892, 50, 70, 80, 1)




INSERT INTO Player(id ,name,surname,id_team,id_country,goals_scored ) VALUES
(1,'Arda', 'Turan', 1, 1, 10),
(2,'Kevin', 'De Bruyne', 2, 5, 12),
(3,'Neymar', 'Jr.', 3, 3, 25),
(4,'Zlatan', 'Ibrahimovic', 4, 5, 20),
(5,'Gabriel', 'Veron', 5, 4, 18),
(6,'Mohamed', 'Salah', 6, 4, 22)


-- 3. İsmi “Türkiye” olan ülkenin liglerinin listesini getiren scripti yazınız.
SELECT * FROM League 
INNER JOIN Country ON Country.id = League.country_id
WHERE Country.name = 'Turkey'


-- 4. İsmi “Türkiye” olan ülkenin takımların listesini getiren scripti yazınız.
SELECT Team.name FROM Team 
INNER JOIN League ON League.id = Team.id_leauge
INNER JOIN Country ON Country.id = League.country_id
WHERE Country.name = 'Turkey'


-- 5. İsmi “Türkiye” olan en üst seviyeli ligdeki puan tablosunu getiren scripti yazınız.
SELECT Team.name, Team.points
FROM Team 
JOIN League ON Team.id_leauge = League.id
JOIN Country ON League.country_id = Country.id
WHERE League.name = 'Super Lig' AND Country.name = 'Turkey'
ORDER BY Team.points DESC


-- 6. Türkiye liglerindeki puan ortalamalarını gösteren scrpiti yazınız.

SELECT League.name , AVG(Team.points) AS average_points
FROM Team 
JOIN League  ON Team.id_leauge = League.id
JOIN Country ON League.country_id = Country.id
WHERE Country.name = 'Turkey'
GROUP BY League.name


-- 7. Bir ligin Gol kralını getiren scprit yazınız. (oyuncu adı, soyadı, takım adı, nereli olduğu)
SELECT MAX(Player.goals_scored), Player."name", Player.surname,Team."name", Country."name"
FROM Player
JOIN Team ON Team.id = Player.id_team
JOIN League ON League.id = Team.id_leauge
JOIN Country ON Country.id = League.country_id
GROUP BY  Player."name", Player.surname,Team."name", Country."name",League."name"
LIMIT 1


-- 8. Tüm liglerde attığı gol yediği golden daha küçük olan takımları getiren scripti yazınız.
SELECT Team."name",Team.goals_scored,Team.goals_conceded
FROM Team
JOIN League ON League.id = Team.id_leauge
JOIN Country ON Country.id = League.country_id
WHERE Team.goals_scored < Team.goals_conceded


--  Bir takımın oyuncularının toplam gol sayısını ve takımın gol sayısını yan yana getiren bir 
--scprit yazınız. (kontrol sorgusu gibi, birisi takım verisi, diğeri oyuncuların toplamı olacak)
SELECT t.name AS team_name, 
       t.goals_scored AS team_goals_scored,p.name as Player_name,
       SUM(p.goals_scored) AS players_total_goals
FROM Team t
LEFT JOIN Player p ON t.id = p.id_team
GROUP BY t.id, t.name, t.goals_scored,p.name
					

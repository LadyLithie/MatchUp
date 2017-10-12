#------------------------------------------------------------
# Table: location
#------------------------------------------------------------

CREATE TABLE location(
        id      BigInt Auto_increment  NOT NULL ,
        address Varchar (255) ,
        city    Varchar (50) ,
        country Varchar (50) ,
        zipcode Varchar (6) ,
        PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: user
#------------------------------------------------------------

CREATE TABLE user(
        id               BigInt Auto_increment  NOT NULL ,
        login            Varchar (30) NOT NULL ,
        password         Varchar (25) NOT NULL ,
        role             enum('ADMIN','CANDIDATE','COMPANY'),
        valid            enum('TRUE','FALSE') NOT NULL DEFAULT 'FALSE',
        created_at       Datetime ,
        updated_at       Datetime ,
        location_id      BigInt ,
        PRIMARY KEY (id ) ,
        UNIQUE (login ) ,
        CONSTRAINT fk_user_location FOREIGN KEY (location_id) REFERENCES location(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: skills
#------------------------------------------------------------

CREATE TABLE skills(
        id         BigInt Auto_increment  NOT NULL ,
        name       Varchar (100) ,
        type       Varchar (100) ,
        PRIMARY KEY (id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: administrator
#------------------------------------------------------------

CREATE TABLE administrator(
          id        BigInt NOT NULL ,
          lastname  Varchar (25) NOT NULL ,
          firstname Varchar (25) NOT NULL ,
          mail      Varchar (100) ,
          phone     Varchar (15) ,
          image     Blob ,
          FOREIGN KEY (id) REFERENCES user(id),
          PRIMARY KEY (id )
)ENGINE=InnoDB;



#------------------------------------------------------------
# Table: company
#------------------------------------------------------------

CREATE TABLE company(
        id           BigInt NOT NULL ,
        name         Varchar (100) ,
        mail         Varchar (100) ,
        description  text ,
        logo         blob ,
        website      Varchar (255) ,
        siret        Varchar(14) ,
        FOREIGN KEY (id) REFERENCES user(id),
        PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: job
#------------------------------------------------------------

CREATE TABLE job(
        id            BigInt Auto_increment  NOT NULL ,
        name          Varchar (100) NOT NULL ,
        presentation  text ,
        contract_type Varchar (100) ,
        created_at    Datetime NOT NULL ,
        updated_at    Datetime NOT NULL ,
        company_id    BigInt ,
        location_id   BigInt ,
        PRIMARY KEY (id ) ,
        CONSTRAINT fk_job_location FOREIGN KEY (location_id) REFERENCES location(id),
        CONSTRAINT fk_job_company FOREIGN KEY (company_id) REFERENCES company(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: candidate
#------------------------------------------------------------

CREATE TABLE candidate(
        id            BigInt Auto_increment  NOT NULL ,
        lastname      Varchar (25) ,
        firstname     Varchar (25) ,
        mail          Varchar (100) ,
        phone         Varchar (15) ,
        presentation  text ,
        picture       blob ,
        FOREIGN KEY (id) REFERENCES user(id),
        PRIMARY KEY (id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: candidate
#------------------------------------------------------------

CREATE TABLE candidate(
        id      BigInt Auto_increment  NOT NULL ,
        link    Varchar (255) ,
        site    Varchar (25) ,
        user_id BigInt NOT NULL ,
        PRIMARY KEY (id) ,
        CONSTRAINT fk_sn_user    FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: candidate_skill
#------------------------------------------------------------

CREATE TABLE candidate_skill(
        candidate_id  BigInt NOT NULL ,
        skill_id      BigInt NOT NULL ,
        PRIMARY KEY (candidate_id ,skill_id),
        CONSTRAINT fk_cs_candidate FOREIGN KEY (candidate_id) REFERENCES candidate(id),
      	CONSTRAINT fk_cs_skill FOREIGN KEY (skill_id) REFERENCES skills(id)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: job_skill
#------------------------------------------------------------

CREATE TABLE job_skill(
        skill_id    BigInt NOT NULL ,
        job_id      BigInt NOT NULL ,
        PRIMARY KEY (skill_id, job_id) ,
        CONSTRAINT fk_js_job FOREIGN KEY (job_id) REFERENCES job(id),
      	CONSTRAINT fk_js_skill FOREIGN KEY (skill_id) REFERENCES skills(id)
)ENGINE=InnoDB;
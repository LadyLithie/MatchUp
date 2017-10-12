#------------------------------------------------------------
# Table: User
#------------------------------------------------------------

CREATE TABLE User(
        id               BigInt Auto_increment  NOT NULL ,
        login            Varchar (30) NOT NULL ,
        password         Varchar (25) NOT NULL ,
        role             enum('ADMIN','CANDIDATE','COMPANY'),
        valid            enum('TRUE','FALSE') NOT NULL DEFAULT 'FALSE',
        created_at       Datetime ,
        updated_at       Datetime ,
        id_Location      Int NOT NULL ,
        PRIMARY KEY (id ) ,
        UNIQUE (login )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Skills
#------------------------------------------------------------

CREATE TABLE Skills(
        id         BigInt Auto_increment  NOT NULL ,
        name       Varchar (100) ,
        type       Varchar (100) ,
        PRIMARY KEY (id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Administrator
#------------------------------------------------------------

CREATE TABLE Administrator(
  CREATE TABLE Administrator(
          id        BigInt NOT NULL ,
          lastname  Varchar (25) NOT NULL ,
          firstname Varchar (25) NOT NULL ,
          mail      Varchar (25) ,
          phone     Varchar (25) ,
          image     Blob ,
          PRIMARY KEY (id )
        FOREIGN KEY (id) REFERENCES User(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Proposal
#------------------------------------------------------------

CREATE TABLE Job(
        id            BigInt Auto_increment  NOT NULL ,
        name          Varchar (100) NOT NULL ,
        presentation  text ,
        contract_type Varchar (100) ,
        created_at    Datetime NOT NULL ,
        updated_at    Datetime NOT NULL ,
        Company_id    Int NOT NULL ,
        Location_id   Int NOT NULL ,
        PRIMARY KEY (id )
        CONSTRAINT fk_job_location FOREIGN KEY (Location_id) REFERENCES location(id),
        CONSTRAINT fk_job_company FOREIGN KEY (Company_id) REFERENCES enterprise(id),
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Company
#------------------------------------------------------------

CREATE TABLE Company(
        id           BigInt Auto_increment  NOT NULL ,
        name         Varchar (255) ,
        mail         Varchar (50) ,
        description  text ,
        logo         blob ,
        website      Varchar (100) ,
        siret        Varchar(14)
        PRIMARY KEY (id),
        FOREIGN KEY (id) REFERENCES User(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Candidate
#------------------------------------------------------------

CREATE TABLE Candidate(
        id            BigInt Auto_increment  NOT NULL ,
        lastname      Varchar (25) ,
        firstname     Varchar (25) ,
        mail          Varchar (100) ,
        presentation  text ,
        picture       blob ,
        PRIMARY KEY (id),
        FOREIGN KEY (id) REFERENCES User(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: Location
#------------------------------------------------------------

CREATE TABLE Location(
        id      BigInt Auto_increment  NOT NULL ,
        address Varchar (255) ,
        city    Varchar (50) ,
        country Varchar (50) ,
        zipcode Varchar (6) ,
        PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: SocialNetwork
#------------------------------------------------------------

CREATE TABLE SocialNetwork(
        id      BigInt Auto_increment  NOT NULL ,
        link    Text ,
        site    Varchar (25) ,
        user_id BigInt NOT NULL ,
        PRIMARY KEY (id)
        CONSTRAINT fk_sn_user    FOREIGN KEY (user_id) REFERENCES User(id),
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: candidate_skill
#------------------------------------------------------------

CREATE TABLE candidate_skill(
        candidate_id  BigInt NOT NULL ,
        skill_id      BigInt NOT NULL ,
        PRIMARY KEY (candidate_id ,skill_id),
        CONSTRAINT fk_cs_candidate FOREIGN KEY (candidate_id) REFERENCES candidate(id),
      	CONSTRAINT fk_cs_skill FOREIGN KEY (skill_id) REFERENCES skill(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


#------------------------------------------------------------
# Table: job_skill
#------------------------------------------------------------

CREATE TABLE job_skill(
        skill_id    BigInt NOT NULL ,
        job_id BigInt NOT NULL ,
        PRIMARY KEY (skill_id, job_id),
        CONSTRAINT fk_cs_job FOREIGN KEY (job_id) REFERENCES Job(id),
      	CONSTRAINT fk_cs_skill FOREIGN KEY (skill_id) REFERENCES skill(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
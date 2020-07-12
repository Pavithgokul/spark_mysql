package com.pavith.learning

import java.util.Properties

import com.typesafe.config.ConfigFactory

case class SparkProps(spark_application_name: String,
                      spark_master: String)

case class MysqlProps(mysql_host: String,
                      mysql_port: String,
                      mysql_user: String,
                      mysql_password: String,
                      mysql_db: String,
                      prop: Properties
                     )

object commons {

  val config = ConfigFactory.load()

  def sparkconf: SparkProps = {

    val sparkAppName = config.getString("spark.app_name")
    val sparkMaster = config.getString("spark.master")

    SparkProps(sparkAppName, sparkMaster)

  }

  def mysqlConfig: MysqlProps = {

    val mysqlHost = config.getString("mysql.host")
    println("Mysql Host Name is : " + mysqlHost)
    val mysqlPort = config.getString("mysql.port")
    val mysqlUser = config.getString("mysql.user")
    val mysqlPassword = config.getString("mysql.password")
    val mysqlDB = config.getString("mysql.database")

    val prop = new Properties()

    prop.setProperty("user", mysqlUser)
    prop.setProperty("password", mysqlPassword)

    MysqlProps(mysqlHost, mysqlPort, mysqlUser, mysqlPassword, mysqlDB, prop)

  }

}

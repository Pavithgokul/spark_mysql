package com.pavith.learning

import org.apache.spark.sql.SparkSession

/**
 * Hello world!
 *
 */
object App extends {

  def main(args: Array[String]): Unit ={


    val sparkConf = commons.sparkconf
    val mysqlConf = commons.mysqlConfig

    println(mysqlConf.mysql_host)
    println(mysqlConf.mysql_port)

    val spark = SparkSession.builder()
      .appName(s"${sparkConf.spark_application_name}")
      .master(s"${sparkConf.spark_master}")
      .getOrCreate()

    System.setProperty("hadoop.home.dir", "C:\\hadoop_utility\\")

    val inputDF = spark.read
        .jdbc("jdbc:mysql://localhost:3306/learning_db", "employee", mysqlConf.prop)

    inputDF.show()

    spark.stop()

  }

}

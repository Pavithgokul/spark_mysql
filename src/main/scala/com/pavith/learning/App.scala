package com.pavith.learning

import org.apache.spark.sql.SparkSession

/**
 * Hello world!
 *
 */
object App extends {

  def main(args: Array[String]): Unit ={

    val spark = SparkSession.builder()
      .appName("Deltalake Learning")
      .master("local")
      .getOrCreate()

    System.setProperty("hadoop.home.dir", "C:\\hadoop_utility\\")

    val inputDF = spark.read
      .option("header", true)
      .option("inferschema", true)
      .csv("D:\\spark_deltalake_learning\\sample.csv")

    inputDF.show()

    spark.stop()

  }

}

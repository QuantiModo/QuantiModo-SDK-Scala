package io.swagger.client.api

import io.swagger.client.model.UnitCategory
import io.swagger.client.model.Unit
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class UnitsApi(val defBasePath: String = "https://localhost/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * Get unit categories
   * Get a list of the categories of measurement units such as &#39;Distance&#39;, &#39;Duration&#39;, &#39;Energy&#39;, &#39;Frequency&#39;, &#39;Miscellany&#39;, &#39;Pressure&#39;, &#39;Proportion&#39;, &#39;Rating&#39;, &#39;Temperature&#39;, &#39;Volume&#39;, and &#39;Weight&#39;.
   * @return UnitCategory
   */
  def v1UnitCategoriesGet () : Option[UnitCategory] = {
    // create path and map variables
    val path = "/v1/unitCategories".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[UnitCategory]).asInstanceOf[UnitCategory])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Get all available units
   * Get all available units
   * @param unitName Unit name
   * @param abbreviatedUnitName Restrict the results to a specific unit by providing the unit abbreviation.
   * @param categoryName Restrict the results to a specific unit category by providing the unit category name.
   * @return List[Unit]
   */
  def v1UnitsGet (unitName: String, abbreviatedUnitName: String, categoryName: String) : Option[List[Unit]] = {
    // create path and map variables
    val path = "/v1/units".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(unitName) != "null") queryParams += "unitName" -> unitName.toString
    if(String.valueOf(abbreviatedUnitName) != "null") queryParams += "abbreviatedUnitName" -> abbreviatedUnitName.toString
    if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Unit]).asInstanceOf[List[Unit]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * Units for Variable
   * Get a list of all possible units to use for a given variable
   * @param unitName Name of Unit you want to retrieve
   * @param abbreviatedUnitName Abbreviated Unit Name of the unit you want
   * @param categoryName Name of the category you want units for
   * @param variable Name of the variable you want units for
   * @return List[Unit]
   */
  def v1UnitsVariableGet (unitName: String, abbreviatedUnitName: String, categoryName: String, variable: String) : Option[List[Unit]] = {
    // create path and map variables
    val path = "/v1/unitsVariable".replaceAll("\\{format\\}","json")

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(unitName) != "null") queryParams += "unitName" -> unitName.toString
    if(String.valueOf(abbreviatedUnitName) != "null") queryParams += "abbreviatedUnitName" -> abbreviatedUnitName.toString
    if(String.valueOf(categoryName) != "null") queryParams += "categoryName" -> categoryName.toString
    if(String.valueOf(variable) != "null") queryParams += "variable" -> variable.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Unit]).asInstanceOf[List[Unit]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}

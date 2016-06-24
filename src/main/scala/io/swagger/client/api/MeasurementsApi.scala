/**
 * QuantiModo
 * Welcome to QuantiModo API! QuantiModo makes it easy to retrieve normalized user data from a wide array of devices and applications. [Learn about QuantiModo](https://quantimo.do) or contact us at <api@quantimo.do>.         Before you get started, you will need to: * Sign in/Sign up, and add some data at [https://app.quantimo.do/api/v2/account/connectors](https://app.quantimo.do/api/v2/account/connectors) to try out the API for yourself * Create an app to get your client id and secret at [https://app.quantimo.do/api/v2/apps](https://app.quantimo.do/api/v2/apps) * As long as you're signed in, it will use your browser's cookie for authentication.  However, client applications must use OAuth2 tokens to access the API.     ## Application Endpoints These endpoints give you access to all authorized users' data for that application. ### Getting Application Token Make a `POST` request to `/api/v2/oauth/access_token`         * `grant_type` Must be `client_credentials`.         * `clientId` Your application's clientId.         * `client_secret` Your application's client_secret.         * `redirect_uri` Your application's redirect url.                ## Example Queries ### Query Options The standard query options for QuantiModo API are as described in the table below. These are the available query options in QuantiModo API: <table>            <thead>                <tr>                    <th>Parameter</th>                    <th>Description</th>                </tr>            </thead>            <tbody>                <tr>                    <td>limit</td>                    <td>The LIMIT is used to limit the number of results returned.  So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records.</td>                </tr>                <tr>                    <td>offset</td>                    <td>Suppose you wanted to show results 11-20. You'd set the    offset to 10 and the limit to 10.</td>                </tr>                <tr>                    <td>sort</td>                    <td>Sort by given field. If the field is prefixed with '-', it    will sort in descending order.</td>                </tr>            </tbody>        </table>         ### Pagination Conventions Since the maximum limit is 200 records, to get more than that you'll have to make multiple API calls and page through the results. To retrieve all the data, you can iterate through data by using the `limit` and `offset` query parameters.For example, if you want to retrieve data from 61-80 then you can use a query with the following parameters,         `/v2/variables?limit=20&offset=60`         Generally, you'll be retrieving new or updated user data. To avoid unnecessary API calls, you'll want to store your last refresh time locally.  Initially, it should be set to 0. Then whenever you make a request to get new data, you should limit the returned results to those updated since your last refresh by appending append         `?lastUpdated=(ge)&quot2013-01-D01T01:01:01&quot`         to your request.         Also for better pagination, you can get link to the records of first, last, next and previous page from response headers: * `Total-Count` - Total number of results for given query * `Link-First` - Link to get first page records * `Link-Last` - Link to get last page records * `Link-Prev` - Link to get previous records set * `Link-Next` - Link to get next records set         Remember, response header will be only sent when the record set is available. e.g. You will not get a ```Link-Last``` & ```Link-Next``` when you query for the last page.         ### Filter operators support API supports the following operators with filter parameters: <br> **Comparison operators**         Comparison operators allow you to limit results to those greater than, less than, or equal to a specified value for a specified attribute. These operators can be used with strings, numbers, and dates. The following comparison operators are available: * `gt` for `greater than` comparison * `ge` for `greater than or equal` comparison * `lt` for `less than` comparison * `le` for `less than or equal` comparison         They are included in queries using the following format:         `(<operator>)<value>`         For example, in order to filter value which is greater than 21, the following query parameter should be used:         `?value=(gt)21` <br><br> **Equals/In Operators**         It also allows filtering by the exact value of an attribute or by a set of values, depending on the type of value passed as a query parameter. If the value contains commas, the parameter is split on commas and used as array input for `IN` filtering, otherwise the exact match is applied. In order to only show records which have the value 42, the following query should be used:         `?value=42`         In order to filter records which have value 42 or 43, the following query should be used:         `?value=42,43` <br><br> **Like operators**         Like operators allow filtering using `LIKE` query. This operator is triggered if exact match operator is used, but value contains `%` sign as the first or last character. In order to filter records which category that start with `Food`, the following query should be used:         `?category=Food%` <br><br> **Negation operator**         It is possible to get negated results of a query by prefixed the operator with `!`. Some examples:         `//filter records except those with value are not 42 or 43`<br> `?value=!42,43`         `//filter records with value not greater than 21`<br> `?value=!(ge)21` <br><br> **Multiple constraints for single attribute**         It is possible to apply multiple constraints by providing an array of query filters:         Filter all records which value is greater than 20.2 and less than 20.3<br> `?value[]=(gt)20.2&value[]=(lt)20.3`         Filter all records which value is greater than 20.2 and less than 20.3 but not 20.2778<br> `?value[]=(gt)20.2&value[]=(lt)20.3&value[]=!20.2778`<br><br> 
 *
 * OpenAPI spec version: 2.0.6
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.swagger.client.api

import io.swagger.client.model.MeasurementSource
import io.swagger.client.model.Measurement
import io.swagger.client.model.MeasurementDelete
import io.swagger.client.model.CommonResponse
import io.swagger.client.model.MeasurementSet
import io.swagger.client.model.MeasurementRange
import java.io.File
import io.swagger.client.model.InlineResponse20012
import io.swagger.client.model.InlineResponse20011
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class MeasurementsApi(val defBasePath: String = "https://app.quantimo.do/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Get measurement sources
   * Returns a list of all the apps from which measurement data is obtained.
   * @return MeasurementSource
   */
  def v1MeasurementSourcesGet () : Option[MeasurementSource] = {
    // create path and map variables
    val path = "/v1/measurementSources".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
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
           Some(ApiInvoker.deserialize(s, "", classOf[MeasurementSource]).asInstanceOf[MeasurementSource])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Add a data source
   * Add a life-tracking app or device to the QuantiModo list of data sources.
   * @param body An array of names of data sources you want to add. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1MeasurementSourcesPost (body: MeasurementSource, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/measurementSources".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling MeasurementsApi->v1MeasurementSourcesPost")

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get daily measurements for this user
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param variableName Name of the variable you want measurements for 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param abbreviatedUnitName The unit your want the measurements in (optional)
   * @param startTime The lower limit of measurements returned (Iso8601) (optional)
   * @param endTime The upper limit of measurements returned (Iso8601) (optional)
   * @param groupingWidth The time (in seconds) over which measurements are grouped together (optional)
   * @param groupingTimezone The time (in seconds) over which measurements are grouped together (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. (optional)
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. (optional)
   * @return Measurement
   */
  def v1MeasurementsDailyGet (variableName: String, accessToken: String, abbreviatedUnitName: String, startTime: String, endTime: String, groupingWidth: Integer, groupingTimezone: String, limit: Integer, offset: Integer, sort: Integer) : Option[Measurement] = {
    // create path and map variables
    val path = "/v1/measurements/daily".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(variableName) != "null") queryParams += "variableName" -> variableName.toString
if(String.valueOf(abbreviatedUnitName) != "null") queryParams += "abbreviatedUnitName" -> abbreviatedUnitName.toString
if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
if(String.valueOf(groupingWidth) != "null") queryParams += "groupingWidth" -> groupingWidth.toString
if(String.valueOf(groupingTimezone) != "null") queryParams += "groupingTimezone" -> groupingTimezone.toString
if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
if(String.valueOf(sort) != "null") queryParams += "sort" -> sort.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[Measurement]).asInstanceOf[Measurement])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Delete a measurement
   * Delete a previously submitted measurement
   * @param body The startTime and variableId of the measurement to be deleted. 
   * @return CommonResponse
   */
  def v1MeasurementsDeletePost (body: MeasurementDelete) : Option[CommonResponse] = {
    // create path and map variables
    val path = "/v1/measurements/delete".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling MeasurementsApi->v1MeasurementsDeletePost")

        
    
    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[CommonResponse]).asInstanceOf[CommonResponse])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get measurements for this user
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten. &lt;br&gt;Supported filter parameters:&lt;br&gt;&lt;ul&gt;&lt;li&gt;&lt;b&gt;value&lt;/b&gt; - Value of measurement&lt;/li&gt;&lt;li&gt;&lt;b&gt;lastUpdated&lt;/b&gt; - The time that this measurement was created or last updated in the UTC format \&quot;YYYY-MM-DDThh:mm:ss\&quot;&lt;/li&gt;&lt;/ul&gt;&lt;br&gt;
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param variableName Name of the variable you want measurements for (optional)
   * @param variableCategoryName Name of the variable category you want measurements for (optional)
   * @param source Name of the source you want measurements for (supports exact name match only) (optional)
   * @param value Value of measurement (optional)
   * @param lastUpdated The time that this measurement was created or last updated in the format \&quot;YYYY-MM-DDThh:mm:ss\&quot; (optional)
   * @param unit The unit you want the measurements returned in (optional)
   * @param startTime The lower limit of measurements returned (Epoch) (optional)
   * @param createdAt The time the measurement record was first created in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local. (optional)
   * @param updatedAt The time the measurement record was last changed in the format YYYY-MM-DDThh:mm:ss. Time zone should be UTC and not local. (optional)
   * @param endTime The upper limit of measurements returned (Epoch) (optional)
   * @param groupingWidth The time (in seconds) over which measurements are grouped together (optional)
   * @param groupingTimezone The time (in seconds) over which measurements are grouped together (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. (optional)
   * @param offset Now suppose you wanted to show results 11-20. You&#39;d set the offset to 10 and the limit to 10. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#x60;-, it will sort in descending order. (optional)
   * @return Measurement
   */
  def v1MeasurementsGet (accessToken: String, variableName: String, variableCategoryName: String, source: String, value: String, lastUpdated: String, unit: String, startTime: String, createdAt: String, updatedAt: String, endTime: String, groupingWidth: Integer, groupingTimezone: String, limit: Integer, offset: Integer, sort: Integer) : Option[Measurement] = {
    // create path and map variables
    val path = "/v1/measurements".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(variableName) != "null") queryParams += "variableName" -> variableName.toString
if(String.valueOf(variableCategoryName) != "null") queryParams += "variableCategoryName" -> variableCategoryName.toString
if(String.valueOf(source) != "null") queryParams += "source" -> source.toString
if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
if(String.valueOf(lastUpdated) != "null") queryParams += "lastUpdated" -> lastUpdated.toString
if(String.valueOf(unit) != "null") queryParams += "unit" -> unit.toString
if(String.valueOf(startTime) != "null") queryParams += "startTime" -> startTime.toString
if(String.valueOf(createdAt) != "null") queryParams += "createdAt" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updatedAt" -> updatedAt.toString
if(String.valueOf(endTime) != "null") queryParams += "endTime" -> endTime.toString
if(String.valueOf(groupingWidth) != "null") queryParams += "groupingWidth" -> groupingWidth.toString
if(String.valueOf(groupingTimezone) != "null") queryParams += "groupingTimezone" -> groupingTimezone.toString
if(String.valueOf(limit) != "null") queryParams += "limit" -> limit.toString
if(String.valueOf(offset) != "null") queryParams += "offset" -> offset.toString
if(String.valueOf(sort) != "null") queryParams += "sort" -> sort.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[Measurement]).asInstanceOf[Measurement])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Post a new set or update existing measurements to the database
   * You can submit or update multiple measurements in a \&quot;measurements\&quot; sub-array.  If the variable these measurements correspond to does not already exist in the database, it will be automatically added.  The request body should look something like [{\&quot;measurements\&quot;:[{\&quot;startTime\&quot;:1439389320,\&quot;value\&quot;:\&quot;3\&quot;}, {\&quot;startTime\&quot;:1439389319,\&quot;value\&quot;:\&quot;2\&quot;}],\&quot;name\&quot;:\&quot;Acne (out of 5)\&quot;,\&quot;source\&quot;:\&quot;QuantiModo\&quot;,\&quot;category\&quot;:\&quot;Symptoms\&quot;,\&quot;combinationOperation\&quot;:\&quot;MEAN\&quot;,\&quot;unit\&quot;:\&quot;/5\&quot;}]
   * @param body An array of measurements you want to insert. 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return void
   */
  def v1MeasurementsPost (body: MeasurementSet, accessToken: String)  = {
    // create path and map variables
    val path = "/v1/measurements".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling MeasurementsApi->v1MeasurementsPost")

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
                  case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get measurements range for this user
   * Get Unix time-stamp (epoch time) of the user&#39;s first and last measurements taken.
   * @param sources Enter source name to limit to specific source (varchar) (optional)
   * @param user If not specified, uses currently logged in user (bigint) (optional)
   * @return MeasurementRange
   */
  def v1MeasurementsRangeGet (sources: String, user: Integer) : Option[MeasurementRange] = {
    // create path and map variables
    val path = "/v1/measurementsRange".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(sources) != "null") queryParams += "sources" -> sources.toString
if(String.valueOf(user) != "null") queryParams += "user" -> user.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[MeasurementRange]).asInstanceOf[MeasurementRange])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get Measurements CSV
   * Download a CSV containing all user measurements
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return File
   */
  def v2MeasurementsCsvGet (accessToken: String) : Option[File] = {
    // create path and map variables
    val path = "/v2/measurements/csv".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[File]).asInstanceOf[File])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Delete Measurement
   * Delete Measurement
   * @param id id of Measurement 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return InlineResponse20012
   */
  def v2MeasurementsIdDelete (id: Integer, accessToken: String) : Option[InlineResponse20012] = {
    // create path and map variables
    val path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "DELETE", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse20012]).asInstanceOf[InlineResponse20012])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get Measurement
   * Get Measurement
   * @param id id of Measurement 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return InlineResponse20011
   */
  def v2MeasurementsIdGet (id: Integer, accessToken: String) : Option[InlineResponse20011] = {
    // create path and map variables
    val path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse20011]).asInstanceOf[InlineResponse20011])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Update Measurement
   * Update Measurement
   * @param id id of Measurement 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param body Measurement that should be updated (optional)
   * @return InlineResponse20012
   */
  def v2MeasurementsIdPut (id: Integer, accessToken: String, body: Measurement) : Option[InlineResponse20012] = {
    // create path and map variables
    val path = "/v2/measurements/{id}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "id" + "\\}",apiInvoker.escape(id))


    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = body

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "PUT", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse20012]).asInstanceOf[InlineResponse20012])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Post Request for Measurements CSV
   * Use this endpoint to schedule a CSV export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return Integer
   */
  def v2MeasurementsRequestCsvPost (accessToken: String) : Option[Integer] = {
    // create path and map variables
    val path = "/v2/measurements/request_csv".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Integer]).asInstanceOf[Integer])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Post Request for Measurements PDF
   * Use this endpoint to schedule a PDF export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return Integer
   */
  def v2MeasurementsRequestPdfPost (accessToken: String) : Option[Integer] = {
    // create path and map variables
    val path = "/v2/measurements/request_pdf".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Integer]).asInstanceOf[Integer])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Post Request for Measurements XLS
   * Use this endpoint to schedule a XLS export containing all user measurements to be emailed to the user within 24 hours.
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return Integer
   */
  def v2MeasurementsRequestXlsPost (accessToken: String) : Option[Integer] = {
    // create path and map variables
    val path = "/v2/measurements/request_xls".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
    
    
    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
    }

    try {
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Integer]).asInstanceOf[Integer])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}

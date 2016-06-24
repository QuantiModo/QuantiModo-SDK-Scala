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

import io.swagger.client.model.InlineResponse2003
import io.swagger.client.model.InlineResponse2004
import io.swagger.client.model.Number
import io.swagger.client.model.InlineResponse2005
import io.swagger.client.model.InlineResponse2001
import io.swagger.client.model.InlineResponse2006
import io.swagger.client.model.InlineResponse2007
import io.swagger.client.model.InlineResponse2008
import io.swagger.client.model.InlineResponse2009
import io.swagger.client.model.InlineResponse20010
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class ApplicationEndpointsApi(val defBasePath: String = "https://app.quantimo.do/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Get all Connections
   * Get all Connections
   * @param accessToken Application&#39;s OAuth2 access token (optional)
   * @param connectorId The id for the connector data source for which the connection is connected (optional)
   * @param connectStatus Indicates whether a connector is currently connected to a service for a user. (optional)
   * @param connectError Error message if there is a problem with authorizing this connection. (optional)
   * @param updateRequestedAt Time at which an update was requested by a user. (optional)
   * @param updateStatus Indicates whether a connector is currently updated. (optional)
   * @param updateError Indicates if there was an error during the update. (optional)
   * @param lastSuccessfulUpdatedAt The time at which the connector was last successfully updated. (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2003
   */
  def v2ApplicationConnectionsGet (accessToken: String, connectorId: Integer, connectStatus: String, connectError: String, updateRequestedAt: String, updateStatus: String, updateError: String, lastSuccessfulUpdatedAt: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2003] = {
    // create path and map variables
    val path = "/v2/application/connections".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
if(String.valueOf(connectStatus) != "null") queryParams += "connect_status" -> connectStatus.toString
if(String.valueOf(connectError) != "null") queryParams += "connect_error" -> connectError.toString
if(String.valueOf(updateRequestedAt) != "null") queryParams += "update_requested_at" -> updateRequestedAt.toString
if(String.valueOf(updateStatus) != "null") queryParams += "update_status" -> updateStatus.toString
if(String.valueOf(updateError) != "null") queryParams += "update_error" -> updateError.toString
if(String.valueOf(lastSuccessfulUpdatedAt) != "null") queryParams += "last_successful_updated_at" -> lastSuccessfulUpdatedAt.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2003]).asInstanceOf[InlineResponse2003])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all Credentials
   * Get all Credentials
   * @param accessToken Application&#39;s OAuth2 access token (optional)
   * @param connectorId The id for the connector data source from which the credential was obtained (optional)
   * @param attrKey Attribute name such as token, userid, username, or password (optional)
   * @param attrValue Encrypted value for the attribute specified (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2004
   */
  def v2ApplicationCredentialsGet (accessToken: String, connectorId: Integer, attrKey: String, attrValue: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2004] = {
    // create path and map variables
    val path = "/v2/application/credentials".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
if(String.valueOf(attrKey) != "null") queryParams += "attr_key" -> attrKey.toString
if(String.valueOf(attrValue) != "null") queryParams += "attr_value" -> attrValue.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2004]).asInstanceOf[InlineResponse2004])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get measurements for all users using your application
   * Measurements are any value that can be recorded like daily steps, a mood rating, or apples eaten.
   * @param accessToken Application&#39;s OAuth2 access token (optional)
   * @param clientId The ID of the client application which originally stored the measurement (optional)
   * @param connectorId The id for the connector data source from which the measurement was obtained (optional)
   * @param variableId ID of the variable for which we are creating the measurement records (optional)
   * @param sourceId Application or device used to record the measurement values (optional)
   * @param startTime start time for the measurement event. Use ISO 8601 datetime format  (optional)
   * @param value The value of the measurement after conversion to the default unit for that variable (optional)
   * @param unitId The default unit id for the variable (optional)
   * @param originalValue Unconverted value of measurement as originally posted (before conversion to default unit) (optional)
   * @param originalUnitId Unit id of the measurement as originally submitted (optional)
   * @param duration Duration of the event being measurement in seconds (optional)
   * @param note An optional note the user may include with their measurement (optional)
   * @param latitude Latitude at which the measurement was taken (optional)
   * @param longitude Longitude at which the measurement was taken (optional)
   * @param location Optional human readable name for the location where the measurement was recorded (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param error An error message if there is a problem with the measurement (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2005
   */
  def v2ApplicationMeasurementsGet (accessToken: String, clientId: String, connectorId: Integer, variableId: Integer, sourceId: Integer, startTime: String, value: Number, unitId: Integer, originalValue: Number, originalUnitId: Integer, duration: Integer, note: String, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, error: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2005] = {
    // create path and map variables
    val path = "/v2/application/measurements".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
if(String.valueOf(sourceId) != "null") queryParams += "source_id" -> sourceId.toString
if(String.valueOf(startTime) != "null") queryParams += "start_time" -> startTime.toString
if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
if(String.valueOf(unitId) != "null") queryParams += "unit_id" -> unitId.toString
if(String.valueOf(originalValue) != "null") queryParams += "original_value" -> originalValue.toString
if(String.valueOf(originalUnitId) != "null") queryParams += "original_unit_id" -> originalUnitId.toString
if(String.valueOf(duration) != "null") queryParams += "duration" -> duration.toString
if(String.valueOf(note) != "null") queryParams += "note" -> note.toString
if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
if(String.valueOf(error) != "null") queryParams += "error" -> error.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2005]).asInstanceOf[InlineResponse2005])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get tracking reminders
   * Get the variable id, frequency, and default value for the user tracking reminders 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param clientId The ID of the client application which last created or updated this trackingReminder (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2001
   */
  def v2ApplicationTrackingRemindersGet (accessToken: String, clientId: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2001] = {
    // create path and map variables
    val path = "/v2/application/trackingReminders".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2001]).asInstanceOf[InlineResponse2001])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all Updates
   * Get all Updates
   * @param accessToken Application&#39;s OAuth2 access token (optional)
   * @param connectorId connector_id (optional)
   * @param numberOfMeasurements number_of_measurements (optional)
   * @param success success (optional)
   * @param message message (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2006
   */
  def v2ApplicationUpdatesGet (accessToken: String, connectorId: Integer, numberOfMeasurements: Integer, success: Boolean, message: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2006] = {
    // create path and map variables
    val path = "/v2/application/updates".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(connectorId) != "null") queryParams += "connector_id" -> connectorId.toString
if(String.valueOf(numberOfMeasurements) != "null") queryParams += "number_of_measurements" -> numberOfMeasurements.toString
if(String.valueOf(success) != "null") queryParams += "success" -> success.toString
if(String.valueOf(message) != "null") queryParams += "message" -> message.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2006]).asInstanceOf[InlineResponse2006])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all UserVariableRelationships
   * Get all UserVariableRelationships
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param id id (optional)
   * @param confidenceLevel Our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors (optional)
   * @param confidenceScore A quantitative representation of our confidence that a consistent predictive relationship exists based on the amount of evidence, reproducibility, and other factors (optional)
   * @param direction Direction is positive if higher predictor values generally precede higher outcome values. Direction is negative if higher predictor values generally precede lower outcome values. (optional)
   * @param durationOfAction Estimated number of seconds following the onset delay in which a stimulus produces a perceivable effect (optional)
   * @param errorMessage error_message (optional)
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect (optional)
   * @param outcomeVariableId Variable ID for the outcome variable (optional)
   * @param predictorVariableId Variable ID for the predictor variable (optional)
   * @param predictorUnitId ID for default unit of the predictor variable (optional)
   * @param sinnRank A value representative of the relevance of this predictor relative to other predictors of this outcome.  Usually used for relevancy sorting. (optional)
   * @param strengthLevel Can be weak, medium, or strong based on the size of the effect which the predictor appears to have on the outcome relative to other variable relationship strength scores. (optional)
   * @param strengthScore A value represented to the size of the effect which the predictor appears to have on the outcome. (optional)
   * @param vote vote (optional)
   * @param valuePredictingHighOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes an above average outcome value (optional)
   * @param valuePredictingLowOutcome Value for the predictor variable (in it&#39;s default unit) which typically precedes a below average outcome value (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2007
   */
  def v2ApplicationUserVariableRelationshipsGet (accessToken: String, id: Integer, confidenceLevel: String, confidenceScore: Number, direction: String, durationOfAction: Integer, errorMessage: String, onsetDelay: Integer, outcomeVariableId: Integer, predictorVariableId: Integer, predictorUnitId: Integer, sinnRank: Number, strengthLevel: String, strengthScore: Number, vote: String, valuePredictingHighOutcome: Number, valuePredictingLowOutcome: Number, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2007] = {
    // create path and map variables
    val path = "/v2/application/userVariableRelationships".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(id) != "null") queryParams += "id" -> id.toString
if(String.valueOf(confidenceLevel) != "null") queryParams += "confidence_level" -> confidenceLevel.toString
if(String.valueOf(confidenceScore) != "null") queryParams += "confidence_score" -> confidenceScore.toString
if(String.valueOf(direction) != "null") queryParams += "direction" -> direction.toString
if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
if(String.valueOf(outcomeVariableId) != "null") queryParams += "outcome_variable_id" -> outcomeVariableId.toString
if(String.valueOf(predictorVariableId) != "null") queryParams += "predictor_variable_id" -> predictorVariableId.toString
if(String.valueOf(predictorUnitId) != "null") queryParams += "predictor_unit_id" -> predictorUnitId.toString
if(String.valueOf(sinnRank) != "null") queryParams += "sinn_rank" -> sinnRank.toString
if(String.valueOf(strengthLevel) != "null") queryParams += "strength_level" -> strengthLevel.toString
if(String.valueOf(strengthScore) != "null") queryParams += "strength_score" -> strengthScore.toString
if(String.valueOf(vote) != "null") queryParams += "vote" -> vote.toString
if(String.valueOf(valuePredictingHighOutcome) != "null") queryParams += "value_predicting_high_outcome" -> valuePredictingHighOutcome.toString
if(String.valueOf(valuePredictingLowOutcome) != "null") queryParams += "value_predicting_low_outcome" -> valuePredictingLowOutcome.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2007]).asInstanceOf[InlineResponse2007])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all UserVariables
   * Get all UserVariables
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param clientId The ID of the client application which last created or updated this user variable (optional)
   * @param parentId ID of the parent variable if this variable has any parent (optional)
   * @param variableId ID of variable (optional)
   * @param defaultUnitId D of unit to use for this variable (optional)
   * @param minimumAllowedValue Minimum reasonable value for this variable (uses default unit) (optional)
   * @param maximumAllowedValue Maximum reasonable value for this variable (uses default unit) (optional)
   * @param fillingValue Value for replacing null measurements (optional)
   * @param joinWith The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables (optional)
   * @param onsetDelay Estimated number of seconds that pass before a stimulus produces a perceivable effect (optional)
   * @param durationOfAction Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect (optional)
   * @param variableCategoryId ID of variable category (optional)
   * @param updated updated (optional)
   * @param public Is variable public (optional)
   * @param causeOnly A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user (optional)
   * @param fillingType 0 -&gt; No filling, 1 -&gt; Use filling-value (optional)
   * @param numberOfMeasurements Number of measurements (optional)
   * @param numberOfProcessedMeasurements Number of processed measurements (optional)
   * @param measurementsAtLastAnalysis Number of measurements at last analysis (optional)
   * @param lastUnitId ID of last Unit (optional)
   * @param lastOriginalUnitId ID of last original Unit (optional)
   * @param lastOriginalValue Last original value which is stored (optional)
   * @param lastValue Last Value (optional)
   * @param lastSourceId ID of last source (optional)
   * @param numberOfCorrelations Number of correlations for this variable (optional)
   * @param status status (optional)
   * @param errorMessage error_message (optional)
   * @param lastSuccessfulUpdateTime When this variable or its settings were last updated (optional)
   * @param standardDeviation Standard deviation (optional)
   * @param variance Variance (optional)
   * @param minimumRecordedValue Minimum recorded value of this variable (optional)
   * @param maximumRecordedValue Maximum recorded value of this variable (optional)
   * @param mean Mean (optional)
   * @param median Median (optional)
   * @param mostCommonUnitId Most common Unit ID (optional)
   * @param mostCommonValue Most common value (optional)
   * @param numberOfUniqueDailyValues Number of unique daily values (optional)
   * @param numberOfChanges Number of changes (optional)
   * @param skewness Skewness (optional)
   * @param kurtosis Kurtosis (optional)
   * @param latitude Latitude (optional)
   * @param longitude Longitude (optional)
   * @param location Location (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param outcome Outcome variables (those with &#x60;outcome&#x60; &#x3D;&#x3D; 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables (optional)
   * @param sources Comma-separated list of source names to limit variables to those sources (optional)
   * @param earliestSourceTime Earliest source time (optional)
   * @param latestSourceTime Latest source time (optional)
   * @param earliestMeasurementTime Earliest measurement time (optional)
   * @param latestMeasurementTime Latest measurement time (optional)
   * @param earliestFillingTime Earliest filling time (optional)
   * @param latestFillingTime Latest filling time (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2008
   */
  def v2ApplicationUserVariablesGet (accessToken: String, clientId: String, parentId: Integer, variableId: Integer, defaultUnitId: Integer, minimumAllowedValue: Number, maximumAllowedValue: Number, fillingValue: Number, joinWith: Integer, onsetDelay: Integer, durationOfAction: Integer, variableCategoryId: Integer, updated: Integer, public: Integer, causeOnly: Boolean, fillingType: String, numberOfMeasurements: Integer, numberOfProcessedMeasurements: Integer, measurementsAtLastAnalysis: Integer, lastUnitId: Integer, lastOriginalUnitId: Integer, lastOriginalValue: Integer, lastValue: Number, lastSourceId: Integer, numberOfCorrelations: Integer, status: String, errorMessage: String, lastSuccessfulUpdateTime: String, standardDeviation: Number, variance: Number, minimumRecordedValue: Number, maximumRecordedValue: Number, mean: Number, median: Number, mostCommonUnitId: Integer, mostCommonValue: Number, numberOfUniqueDailyValues: Number, numberOfChanges: Integer, skewness: Number, kurtosis: Number, latitude: Number, longitude: Number, location: String, createdAt: String, updatedAt: String, outcome: Boolean, sources: String, earliestSourceTime: Integer, latestSourceTime: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, earliestFillingTime: Integer, latestFillingTime: Integer, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2008] = {
    // create path and map variables
    val path = "/v2/application/userVariables".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
if(String.valueOf(parentId) != "null") queryParams += "parent_id" -> parentId.toString
if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
if(String.valueOf(defaultUnitId) != "null") queryParams += "default_unit_id" -> defaultUnitId.toString
if(String.valueOf(minimumAllowedValue) != "null") queryParams += "minimum_allowed_value" -> minimumAllowedValue.toString
if(String.valueOf(maximumAllowedValue) != "null") queryParams += "maximum_allowed_value" -> maximumAllowedValue.toString
if(String.valueOf(fillingValue) != "null") queryParams += "filling_value" -> fillingValue.toString
if(String.valueOf(joinWith) != "null") queryParams += "join_with" -> joinWith.toString
if(String.valueOf(onsetDelay) != "null") queryParams += "onset_delay" -> onsetDelay.toString
if(String.valueOf(durationOfAction) != "null") queryParams += "duration_of_action" -> durationOfAction.toString
if(String.valueOf(variableCategoryId) != "null") queryParams += "variable_category_id" -> variableCategoryId.toString
if(String.valueOf(updated) != "null") queryParams += "updated" -> updated.toString
if(String.valueOf(public) != "null") queryParams += "public" -> public.toString
if(String.valueOf(causeOnly) != "null") queryParams += "cause_only" -> causeOnly.toString
if(String.valueOf(fillingType) != "null") queryParams += "filling_type" -> fillingType.toString
if(String.valueOf(numberOfMeasurements) != "null") queryParams += "number_of_measurements" -> numberOfMeasurements.toString
if(String.valueOf(numberOfProcessedMeasurements) != "null") queryParams += "number_of_processed_measurements" -> numberOfProcessedMeasurements.toString
if(String.valueOf(measurementsAtLastAnalysis) != "null") queryParams += "measurements_at_last_analysis" -> measurementsAtLastAnalysis.toString
if(String.valueOf(lastUnitId) != "null") queryParams += "last_unit_id" -> lastUnitId.toString
if(String.valueOf(lastOriginalUnitId) != "null") queryParams += "last_original_unit_id" -> lastOriginalUnitId.toString
if(String.valueOf(lastOriginalValue) != "null") queryParams += "last_original_value" -> lastOriginalValue.toString
if(String.valueOf(lastValue) != "null") queryParams += "last_value" -> lastValue.toString
if(String.valueOf(lastSourceId) != "null") queryParams += "last_source_id" -> lastSourceId.toString
if(String.valueOf(numberOfCorrelations) != "null") queryParams += "number_of_correlations" -> numberOfCorrelations.toString
if(String.valueOf(status) != "null") queryParams += "status" -> status.toString
if(String.valueOf(errorMessage) != "null") queryParams += "error_message" -> errorMessage.toString
if(String.valueOf(lastSuccessfulUpdateTime) != "null") queryParams += "last_successful_update_time" -> lastSuccessfulUpdateTime.toString
if(String.valueOf(standardDeviation) != "null") queryParams += "standard_deviation" -> standardDeviation.toString
if(String.valueOf(variance) != "null") queryParams += "variance" -> variance.toString
if(String.valueOf(minimumRecordedValue) != "null") queryParams += "minimum_recorded_value" -> minimumRecordedValue.toString
if(String.valueOf(maximumRecordedValue) != "null") queryParams += "maximum_recorded_value" -> maximumRecordedValue.toString
if(String.valueOf(mean) != "null") queryParams += "mean" -> mean.toString
if(String.valueOf(median) != "null") queryParams += "median" -> median.toString
if(String.valueOf(mostCommonUnitId) != "null") queryParams += "most_common_unit_id" -> mostCommonUnitId.toString
if(String.valueOf(mostCommonValue) != "null") queryParams += "most_common_value" -> mostCommonValue.toString
if(String.valueOf(numberOfUniqueDailyValues) != "null") queryParams += "number_of_unique_daily_values" -> numberOfUniqueDailyValues.toString
if(String.valueOf(numberOfChanges) != "null") queryParams += "number_of_changes" -> numberOfChanges.toString
if(String.valueOf(skewness) != "null") queryParams += "skewness" -> skewness.toString
if(String.valueOf(kurtosis) != "null") queryParams += "kurtosis" -> kurtosis.toString
if(String.valueOf(latitude) != "null") queryParams += "latitude" -> latitude.toString
if(String.valueOf(longitude) != "null") queryParams += "longitude" -> longitude.toString
if(String.valueOf(location) != "null") queryParams += "location" -> location.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
if(String.valueOf(outcome) != "null") queryParams += "outcome" -> outcome.toString
if(String.valueOf(sources) != "null") queryParams += "sources" -> sources.toString
if(String.valueOf(earliestSourceTime) != "null") queryParams += "earliest_source_time" -> earliestSourceTime.toString
if(String.valueOf(latestSourceTime) != "null") queryParams += "latest_source_time" -> latestSourceTime.toString
if(String.valueOf(earliestMeasurementTime) != "null") queryParams += "earliest_measurement_time" -> earliestMeasurementTime.toString
if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latest_measurement_time" -> latestMeasurementTime.toString
if(String.valueOf(earliestFillingTime) != "null") queryParams += "earliest_filling_time" -> earliestFillingTime.toString
if(String.valueOf(latestFillingTime) != "null") queryParams += "latest_filling_time" -> latestFillingTime.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2008]).asInstanceOf[InlineResponse2008])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all VariableUserSources
   * Get all VariableUserSources
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param variableId ID of variable (optional)
   * @param timestamp Time that this measurement occurred Uses epoch minute (epoch time divided by 60) (optional)
   * @param earliestMeasurementTime Earliest measurement time (optional)
   * @param latestMeasurementTime Latest measurement time (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2009
   */
  def v2ApplicationVariableUserSourcesGet (accessToken: String, variableId: Integer, timestamp: Integer, earliestMeasurementTime: Integer, latestMeasurementTime: Integer, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2009] = {
    // create path and map variables
    val path = "/v2/application/variableUserSources".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(variableId) != "null") queryParams += "variable_id" -> variableId.toString
if(String.valueOf(timestamp) != "null") queryParams += "timestamp" -> timestamp.toString
if(String.valueOf(earliestMeasurementTime) != "null") queryParams += "earliest_measurement_time" -> earliestMeasurementTime.toString
if(String.valueOf(latestMeasurementTime) != "null") queryParams += "latest_measurement_time" -> latestMeasurementTime.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2009]).asInstanceOf[InlineResponse2009])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get all Votes
   * Get all Votes
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param clientId The ID of the client application which last created or updated this vote (optional)
   * @param causeId ID of predictor variable (optional)
   * @param effectId ID of outcome variable (optional)
   * @param value Value of Vote. 1 is for upvote. 0 is for downvote.  Otherwise, there is no vote. (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse20010
   */
  def v2ApplicationVotesGet (accessToken: String, clientId: String, causeId: Integer, effectId: Integer, value: Integer, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse20010] = {
    // create path and map variables
    val path = "/v2/application/votes".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(clientId) != "null") queryParams += "client_id" -> clientId.toString
if(String.valueOf(causeId) != "null") queryParams += "cause_id" -> causeId.toString
if(String.valueOf(effectId) != "null") queryParams += "effect_id" -> effectId.toString
if(String.valueOf(value) != "null") queryParams += "value" -> value.toString
if(String.valueOf(createdAt) != "null") queryParams += "created_at" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updated_at" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse20010]).asInstanceOf[InlineResponse20010])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}

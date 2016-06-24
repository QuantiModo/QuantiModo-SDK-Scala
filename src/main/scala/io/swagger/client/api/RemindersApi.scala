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

import io.swagger.client.model.InlineResponse200
import io.swagger.client.model.CommonResponse
import io.swagger.client.model.TrackingReminderNotificationSkip
import io.swagger.client.model.TrackingReminderNotificationSnooze
import io.swagger.client.model.TrackingReminderNotificationTrack
import io.swagger.client.model.TrackingReminderDelete
import io.swagger.client.model.InlineResponse2001
import io.swagger.client.model.TrackingReminder
import io.swagger.client.model.InlineResponse2002
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class RemindersApi(val defBasePath: String = "https://app.quantimo.do/api",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  /**
   * Get specific pending tracking reminders
   * Specfic pending reminder instances that still need to be tracked.  
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param variableCategoryName Limit tracking reminder notifications to a specific variable category (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format. Time zone should be UTC and not local.  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format. Time zone should be UTC and not local.  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse200
   */
  def v1TrackingReminderNotificationsGet (accessToken: String, variableCategoryName: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse200] = {
    // create path and map variables
    val path = "/v1/trackingReminderNotifications".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(variableCategoryName) != "null") queryParams += "variableCategoryName" -> variableCategoryName.toString
if(String.valueOf(createdAt) != "null") queryParams += "createdAt" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updatedAt" -> updatedAt.toString
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
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse200]).asInstanceOf[InlineResponse200])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Skip a pending tracking reminder
   * Deletes the pending tracking reminder
   * @param body Id of the pending reminder to be skipped or deleted 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return CommonResponse
   */
  def v1TrackingReminderNotificationsSkipPost (body: TrackingReminderNotificationSkip, accessToken: String) : Option[CommonResponse] = {
    // create path and map variables
    val path = "/v1/trackingReminderNotifications/skip".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling RemindersApi->v1TrackingReminderNotificationsSkipPost")

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
           Some(ApiInvoker.deserialize(s, "", classOf[CommonResponse]).asInstanceOf[CommonResponse])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Snooze a pending tracking reminder
   * Changes the reminder time to now plus one hour
   * @param body Id of the pending reminder to be snoozed 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return CommonResponse
   */
  def v1TrackingReminderNotificationsSnoozePost (body: TrackingReminderNotificationSnooze, accessToken: String) : Option[CommonResponse] = {
    // create path and map variables
    val path = "/v1/trackingReminderNotifications/snooze".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling RemindersApi->v1TrackingReminderNotificationsSnoozePost")

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
           Some(ApiInvoker.deserialize(s, "", classOf[CommonResponse]).asInstanceOf[CommonResponse])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Track a pending tracking reminder
   * Adds the default measurement for the pending tracking reminder with the reminder time as the measurment start time
   * @param body Id of the pending reminder to be tracked 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return CommonResponse
   */
  def v1TrackingReminderNotificationsTrackPost (body: TrackingReminderNotificationTrack, accessToken: String) : Option[CommonResponse] = {
    // create path and map variables
    val path = "/v1/trackingReminderNotifications/track".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling RemindersApi->v1TrackingReminderNotificationsTrackPost")

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
           Some(ApiInvoker.deserialize(s, "", classOf[CommonResponse]).asInstanceOf[CommonResponse])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Delete tracking reminder
   * Delete previously created tracking reminder
   * @param body Id of reminder to be deleted 
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @return CommonResponse
   */
  def v1TrackingRemindersDeletePost (body: TrackingReminderDelete, accessToken: String) : Option[CommonResponse] = {
    // create path and map variables
    val path = "/v1/trackingReminders/delete".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if (body == null) throw new Exception("Missing required parameter 'body' when calling RemindersApi->v1TrackingRemindersDeletePost")

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
           Some(ApiInvoker.deserialize(s, "", classOf[CommonResponse]).asInstanceOf[CommonResponse])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

  /**
   * Get repeating tracking reminder settings
   * Users can be reminded to track certain variables at a specified frequency with a default value.  
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param variableCategoryName Limit tracking reminders to a specific variable category (optional)
   * @param createdAt When the record was first created. Use ISO 8601 datetime format. Time zone should be UTC and not local.  (optional)
   * @param updatedAt When the record was last updated. Use ISO 8601 datetime format. Time zone should be UTC and not local.  (optional)
   * @param limit The LIMIT is used to limit the number of results returned. So if you have 1000 results, but only want to the first 10, you would set this to 10 and offset to 0. The maximum limit is 200 records. (optional)
   * @param offset OFFSET says to skip that many rows before beginning to return rows to the client. OFFSET 0 is the same as omitting the OFFSET clause. If both OFFSET and LIMIT appear, then OFFSET rows are skipped before starting to count the LIMIT rows that are returned. (optional)
   * @param sort Sort by given field. If the field is prefixed with &#39;-&#39;, it will sort in descending order. (optional)
   * @return InlineResponse2001
   */
  def v1TrackingRemindersGet (accessToken: String, variableCategoryName: String, createdAt: String, updatedAt: String, limit: Integer, offset: Integer, sort: String) : Option[InlineResponse2001] = {
    // create path and map variables
    val path = "/v1/trackingReminders".replaceAll("\\{format\\}","json")
    val contentTypes = List("application/json", "application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    if(String.valueOf(accessToken) != "null") queryParams += "access_token" -> accessToken.toString
if(String.valueOf(variableCategoryName) != "null") queryParams += "variableCategoryName" -> variableCategoryName.toString
if(String.valueOf(createdAt) != "null") queryParams += "createdAt" -> createdAt.toString
if(String.valueOf(updatedAt) != "null") queryParams += "updatedAt" -> updatedAt.toString
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
   * Store a Tracking Reminder
   * This is to enable users to create reminders to track a variable with a default value at a specified frequency
   * @param accessToken User&#39;s OAuth2 access token (optional)
   * @param body TrackingReminder that should be stored (optional)
   * @return InlineResponse2002
   */
  def v1TrackingRemindersPost (accessToken: String, body: TrackingReminder) : Option[InlineResponse2002] = {
    // create path and map variables
    val path = "/v1/trackingReminders".replaceAll("\\{format\\}","json")
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
      apiInvoker.invokeApi(basePath, path, "POST", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[InlineResponse2002]).asInstanceOf[InlineResponse2002])
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }

}

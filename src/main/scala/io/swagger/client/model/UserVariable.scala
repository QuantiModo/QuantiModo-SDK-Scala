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

package io.swagger.client.model

import org.joda.time.DateTime



case class UserVariable (
  /* ID of the parent variable if this variable has any parent */
  parentId: Integer,
/* User ID */
  userId: Integer,
/* client_id */
  clientId: String,
/* ID of variable */
  variableId: Integer,
/* ID of unit to use for this variable */
  defaultUnitId: Integer,
/* Minimum reasonable value for this variable (uses default unit) */
  minimumAllowedValue: Float,
/* Maximum reasonable value for this variable (uses default unit) */
  maximumAllowedValue: Float,
/* Value for replacing null measurements */
  fillingValue: Float,
/* The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables */
  joinWith: Integer,
/* How long it takes for a measurement in this variable to take effect */
  onsetDelay: Integer,
/* Estimated duration of time following the onset delay in which a stimulus produces a perceivable effect */
  durationOfAction: Integer,
/* ID of variable category */
  variableCategoryId: Integer,
/* updated */
  updated: Integer,
/* Is variable public */
  public: Integer,
/* A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user */
  causeOnly: Boolean,
/* 0 -> No filling, 1 -> Use filling-value */
  fillingType: String,
/* Number of measurements */
  numberOfMeasurements: Integer,
/* Number of processed measurements */
  numberOfProcessedMeasurements: Integer,
/* Number of measurements at last analysis */
  measurementsAtLastAnalysis: Integer,
/* ID of last Unit */
  lastUnitId: Integer,
/* ID of last original Unit */
  lastOriginalUnitId: Integer,
/* Last Value */
  lastValue: Float,
/* Last original value which is stored */
  lastOriginalValue: Integer,
/* ID of last source */
  lastSourceId: Integer,
/* Number of correlations for this variable */
  numberOfCorrelations: Integer,
/* status */
  status: String,
/* error_message */
  errorMessage: String,
/* When this variable or its settings were last updated */
  lastSuccessfulUpdateTime: DateTime,
/* Standard deviation */
  standardDeviation: Float,
/* Variance */
  variance: Float,
/* Minimum recorded value of this variable */
  minimumRecordedValue: Float,
/* Maximum recorded daily value of this variable */
  maximumRecordedDailyValue: Float,
/* Mean */
  mean: Float,
/* Median */
  median: Float,
/* Most common Unit ID */
  mostCommonUnitId: Integer,
/* Most common value */
  mostCommonValue: Float,
/* Number of unique daily values */
  numberOfUniqueDailyValues: Float,
/* Number of changes */
  numberOfChanges: Integer,
/* Skewness */
  skewness: Float,
/* Kurtosis */
  kurtosis: Float,
/* Latitude */
  latitude: Float,
/* Longitude */
  longitude: Float,
/* Location */
  location: String,
/* Earliest measurement start_time to be used in analysis. Use ISO 8601 datetime format */
  experimentStartTime: DateTime,
/* Latest measurement start_time to be used in analysis. Use ISO 8601 datetime format */
  experimentEndTime: DateTime,
/* When the record was first created. Use ISO 8601 datetime format */
  createdAt: DateTime,
/* When the record in the database was last updated. Use ISO 8601 datetime format */
  updatedAt: DateTime,
/* Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables */
  outcome: Boolean,
/* Comma-separated list of source names to limit variables to those sources */
  sources: String,
/* Earliest source time */
  earliestSourceTime: Integer,
/* Latest source time */
  latestSourceTime: Integer,
/* Earliest measurement time */
  earliestMeasurementTime: Integer,
/* Latest measurement time */
  latestMeasurementTime: Integer,
/* Earliest filling time */
  earliestFillingTime: Integer,
/* Latest filling time */
  latestFillingTime: Integer)

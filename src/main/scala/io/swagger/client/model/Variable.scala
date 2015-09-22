package io.swagger.client.model




case class Variable (
  /* Variable ID */
  id: Integer,
  /* User-defined variable display name. */
  name: String,
  /* Name used when the variable was originally created in the `variables` table. */
  originalName: String,
  /* Variable category like Mood, Sleep, Physical Activity, Treatment, Symptom, etc. */
  category: String,
  /* Abbreviated name of the default unit for the variable */
  abbreviatedUnitName: String,
  /* Id of the default unit for the variable */
  abbreviatedUnitId: Integer,
  /* Comma-separated list of source names to limit variables to those sources */
  sources: String,
  /* Minimum reasonable value for this variable (uses default unit) */
  minimumValue: Double,
  /* Maximum reasonable value for this variable (uses default unit) */
  maximumValue: Double,
  /* How to aggregate measurements over time. */
  combinationOperation: String,
  /* Value for replacing null measurements */
  fillingValue: Double,
  /* The Variable this Variable should be joined with. If the variable is joined with some other variable then it is not shown to user in the list of variables. */
  joinWith: String,
  /* Array of Variables that are joined with this Variable */
  joinedVariables: List[Variable],
  /* Id of the parent variable if this variable has any parent */
  parent: Integer,
  /* Array of Variables that are sub variables to this Variable */
  subVariables: List[Variable],
  /* How long it takes for a measurement in this variable to take effect */
  onsetDelay: Integer,
  /* How long the effect of a measurement in this variable lasts */
  durationOfAction: Integer,
  /* Earliest measurement time */
  earliestMeasurementTime: Integer,
  /* Latest measurement time */
  latestMeasurementTime: Integer,
  /* When this variable or its settings were last updated */
  updated: Integer,
  /* A value of 1 indicates that this variable is generally a cause in a causal relationship.  An example of a causeOnly variable would be a variable such as Cloud Cover which would generally not be influenced by the behaviour of the user. */
  causeOnly: Integer,
  /* Number of correlations */
  numberOfCorrelations: Integer,
  /* Outcome variables (those with `outcome` == 1) are variables for which a human would generally want to identify the influencing factors.  These include symptoms of illness, physique, mood, cognitive performance, etc.  Generally correlation calculations are only performed on outcome variables. */
  outcome: Integer,
  /* The number of measurements that a given user had for this variable the last time a correlation calculation was performed. Generally correlation values are only updated once the current number of measurements for a variable is more than 10% greater than the measurementsAtLastAnalysis.  This avoids a computationally-demanding recalculation when there's not enough new data to make a significant difference in the correlation. */
  measurementsAtLastAnalysis: Integer,
  /* Number of measurements */
  numberOfMeasurements: Integer,
  /* Last unit */
  lastUnit: String,
  /* Last value */
  lastValue: Integer,
  /* Most common value */
  mostCommonValue: Integer,
  /* Most common unit */
  mostCommonUnit: String,
  /* Last source */
  lastSource: Integer)
  

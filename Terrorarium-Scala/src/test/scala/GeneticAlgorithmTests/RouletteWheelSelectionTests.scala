package GeneticAlgorithmTests

import GeneticAlgorithm.Individual
import GeneticAlgorithm.Selection.RouletteWheelSelection
import TestObjects.*

class RouletteWheelSelectionTests extends munit.FunSuite:

  test("Roulette Wheel Returns Correct Individual") {
    val testIndividuals =
      List(
        TestIndividual.NewIndividual().copy(Fitness = 1.0),
        TestIndividual.NewIndividual().copy(Fitness = 2.0),
        TestIndividual.NewIndividual().copy(Fitness = 3.0))
        .toVector

    val actual1 = RouletteWheelSelection.GetIndividual(testIndividuals, 0.1)
    val actual2 = RouletteWheelSelection.GetIndividual(testIndividuals, 0.4)
    val actual3 = RouletteWheelSelection.GetIndividual(testIndividuals, 0.6)

    assertEquals(actual1, testIndividuals(0))
    assertEquals(actual2, testIndividuals(1))
    assertEquals(actual3, testIndividuals(2))


  }

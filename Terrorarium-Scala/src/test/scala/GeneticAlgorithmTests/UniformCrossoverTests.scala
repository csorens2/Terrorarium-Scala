package GeneticAlgorithmTests

import GeneticAlgorithm._
import GeneticAlgorithm.Crossover._

class UniformCrossoverTests extends munit.FunSuite:

  test("UniformCrossover crossovers properly") {
    val chromosome1 = Chromosome(Vector(1.0, 0.0))
    val chromosome2 = Chromosome(Vector(0.0, 1.0))
    val choiceBools = LazyList(true, false)
    val expectedGenes = Chromosome(Vector(1.0, 1.0))

    val resultGenes = UniformCrossover.PerformCrossover(chromosome1, chromosome2, choiceBools)
    assertEquals(resultGenes, expectedGenes)
  }

  test("UniformCrossover throws IllegalArgumentException if parent genes are not the same length") {
    val chromosome1 = Chromosome(Vector(1.0, 0.0))
    val chromosome2 = Chromosome(Vector(0.0))
    val choiceBools = LazyList(true, false)

    intercept[IllegalArgumentException] {
      UniformCrossover.PerformCrossover(chromosome1, chromosome2, choiceBools)
    }
  }

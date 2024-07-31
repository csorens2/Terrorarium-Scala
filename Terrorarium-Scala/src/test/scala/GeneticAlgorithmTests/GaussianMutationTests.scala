package GeneticAlgorithmTests

import GeneticAlgorithm.Chromosome
import GeneticAlgorithm.Mutation.*

class GaussianMutationTests extends munit.FunSuite:

  test("GaussianMutation throws exception if given invalid chance") {
    intercept[IllegalArgumentException] {
      GaussianMutation.Mutate(-1.0, 0.0, Chromosome(Vector.empty))
    }
    intercept[IllegalArgumentException] {
      GaussianMutation.Mutate(2.0, 0.0, Chromosome(Vector.empty))
    }
  }
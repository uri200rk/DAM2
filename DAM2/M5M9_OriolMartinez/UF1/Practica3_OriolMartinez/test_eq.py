import unittest

from solucionadorEquacions import EqPrimG

class TestEquacio(unittest.TestCase):
   
    def test_positiu(self):
        eq = EqPrimG("2x + 3 = 7")
        self.assertEqual(eq.calcula(),2.0)
    
    def testincorrecte(self):
        eq = EqPrimG("2x / 3 = 7")
        self.assertEqual(eq.calcula(),"Operador no valid: ")

    def test_negatiu(self):
        eq = EqPrimG("2x - 3 = 7")
        self.assertEqual(eq.calcula(),5)

    def test_float(self):
        eq = EqPrimG("2.3x - 8.4 = 9.8")
        self.assertEqual(eq.calcula(),7.913043478260872)

    def test_caracterErroni(self):
        eq = EqPrimG("2x - p = 7")
        self.assertEqual(eq.calcula(),"l'equacio te un caracter no calculable o no segueix el format: ax + b = c")

    def test_fromat_erroni(self):
        eq = EqPrimG("3 - 2x = 7")
        self.assertEqual(eq.calcula(),"l'equacio te un caracter no calculable o no segueix el format: ax + b = c"
        )



if __name__ == '__main__':
    unittest.main()
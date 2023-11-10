primos :: Int -> [Int]
primos n = filter primoVerificacion [2..n]

pedirNumero :: IO Int
pedirNumero = do 
    putStrLn "¿Hasta donde quiere que llegue la lista de primos?"
    n <- readLn :: IO Int
    return n

primoVerificacion :: Int -> Bool
primoVerificacion n = length [x | x <- [1..n], n `mod` x == 0] == 2

main :: IO ()
main = do
    numero <- pedirNumero
    print (primos numero)

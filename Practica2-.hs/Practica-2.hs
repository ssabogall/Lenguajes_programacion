-- Función Principal donde es una compuesta y de alto orden
pedirNumeros :: IO [Int]
pedirNumeros = do
    putStrLn "¿Cuántos números desea ingresar?"
    n <- readLn :: IO Int
    if n == 10
        then do
            putStrLn "Puede Ingrese los 10 números separados por guiones (por ejemplo, 1-2-3-4-5-6-7-8-9-10):"
            entrada <- getLine
            let numerosStr = funcionSeparadora entrada
            let numeros = convertirLista numerosStr
            if length numeros == 10
                then do
                    putStrLn "Los números ingresados son:"
                    print numeros
                    funcionISBN numeros
                    return numeros
                else do
                    putStrLn "Debe ingresar exactamente 10 números separados por guiones para que el código sea correcto."
                    return []
        else do
            putStrLn "No puedes ingresar más o menos de 10 números para que el código sea correcto"
            return []

-- Función para dividir una cadena en números usando guiones como separadores
funcionSeparadora :: String -> [String]
funcionSeparadora entrada = filtrarLista (== '-') entrada

-- Función para dividir una cadena en palabras usando un delimitador
filtrarLista :: (Char -> Bool) -> String -> [String]
filtrarLista p s = case dropWhile p s of
    "" -> []
    s' -> w : filtrarLista p s''
        where (w, s'') = break p s'

-- Función para calcular si es un código ISBN válido
funcionISBN :: [Int] -> IO ()
funcionISBN numeros = do
    let listaPre = [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
    let resultado = zipWith (*) numeros listaPre
    funcionValidadora resultado

-- Función para validar el código ISBN
funcionValidadora :: [Int] -> IO ()
funcionValidadora resultado = do
    let suma = sum resultado
    if (suma `mod` 11 == 0)
        then
            putStrLn "Es un código ISBN registrado en la biblioteca."
        else
            putStrLn "No es un código ISBN válido. Revise si escribió el código correctamente e inténtelo de nuevo."

-- Función para convertir una lista de cadenas en una lista de enteros
convertirLista :: [String] -> [Int]
convertirLista = map read

-- Función Principal
main :: IO ()
main = do
    numeros <- pedirNumeros
    putStrLn "Feliz dia :D"

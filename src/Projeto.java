import java.util.Scanner;

public class Projeto {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        // a)
        int numPessoas, numDias;
        //ler a linha("Sales dept. - november") antes dos números
        if (ler.hasNextLine())
            ler.nextLine();
        //ler as dimensões e criar a matriz
        numPessoas = ler.nextInt();
        numDias = ler.nextInt();
        int[][] moodMap = new int[numPessoas][numDias];
        //chamar a função para preencher a matriz
        lerInformacoes(moodMap);

        // b)
        //chamar a função para visualizar a matriz formatada
        visualizarFormatado(moodMap);

        // c)
        //chamar o metodo para calcular a media por dia
        mediaHumorPorDia(moodMap);

        // d)
        mediaHumorPorPessoa(moodMap);
    }

    // a)
    public static void lerInformacoes(int[][] moodMap) {
        for (int linhas = 0; linhas < moodMap.length; linhas++) { //ler o numero da primeira pessoa na primeira linha
            for (int colunas = 0; colunas < moodMap[linhas].length; colunas++) { //passa à próxima coluna para o próximo dia
                moodMap[linhas][colunas] = ler.nextInt();

            }
        }
    }

    // b)
    public static void visualizarFormatado(int[][] moodMap) {  // visualizar a tabela do ex b)
        System.out.println("b) Mood (level/day(person)");
        formatarDias(moodMap);
        formatarMatriz(moodMap);
        System.out.println();
    }
    public static void formatarDias(int[][] moodMap) {
        System.out.print("day       :");

        //serve para apresentar os dias com 4 espaços antes do respetivo número do dia
        for (int dias = 0; dias < moodMap[0].length; dias++) {
            System.out.printf("%3d ", dias);
        }
        System.out.println(); //passar para a linha seguinte pra deixar bem formatado
        System.out.print("----------|");

        // para cada dia o for vai imprimir "---|"
        for (int dias = 0; dias < moodMap[0].length; dias++) {
            System.out.print("---|");
        }
        System.out.println();
    }

    public static void formatarMatriz(int[][] moodMap) {
        //vai imprimir para cada pessoa/linha o respetivo número da pessoa
        for (int linhas = 0; linhas < moodMap.length; linhas++) {
            System.out.printf("Person #%d :", linhas);
            //para cada coluna/dia vai imprimir os números da matriz
            for (int dias = 0; dias < moodMap[linhas].length; dias++) {
                System.out.printf("%3d ", moodMap[linhas][dias]);

            }
            System.out.println();
        }
    }

    // c)
    public static void mediaHumorPorDia(int[][] moodMap) {
        double [] mediaHumorPorDias = new double[moodMap[0].length]; // array para armazenar o valor das médias
        for (int coluna = 0; coluna < moodMap[0].length; coluna++) { // vai percorrer cada dia/coluna
            double somaColuna = 0.0;
            for (int linha = 0; linha < moodMap.length; linha++) { // vai percorrer cada pessoa/linha
                somaColuna += moodMap[linha][coluna]; // calcula a soma dos elementos da coluna
            }
            double mediaPorDia = somaColuna / moodMap.length; // calcula a media dos elementos da coluna
            mediaHumorPorDias[coluna] = mediaPorDia; // armazena o valor da média no array
        }
        System.out.println("c) Average mood each day:");
        formatarDias(moodMap);
        formatarMediaPorDia(mediaHumorPorDias);
        System.out.println();
    }

    public static void formatarMediaPorDia(double[] mediaHumorPorDia) {
        //para cada coluna/dia vai imprimir os números da matriz
        System.out.print("mood       ");
        for (int dias = 0; dias < mediaHumorPorDia.length; dias++) {
            System.out.printf("%.1f ", mediaHumorPorDia[dias]);
        }
        System.out.println();

    }

    // d)
    public static void mediaHumorPorPessoa (int[][] moodMap) {
        double[] mediaHumorPorPessoa = new double[moodMap.length];
        for (int linhas = 0; linhas < moodMap.length; linhas++) {
            double somaLinha = 0.0;
            for (int colunas = 0; colunas < moodMap[linhas].length; colunas++) {
                somaLinha += moodMap[linhas][colunas];
            }
            double mediaPorPessoa = somaLinha / moodMap[linhas].length;
            mediaHumorPorPessoa[linhas] = mediaPorPessoa;
        }
        System.out.println("d) Average of each person's mood:");
        formatarMatriz(moodMap); // ESTE MODULO É PARA O MOODMAP/ FAZEMOS UM MODULO NOVO?
        formatarMediaPorPessoa(mediaHumorPorPessoa);
    }
    public static void formatarMediaPorPessoa(double[] mediaHumorPorDia) {
        //para cada linha/pessoa vai imprimir os números da matriz
        for (int dias = 0; dias < mediaHumorPorDia.length; dias++) {
            System.out.printf("%.1f ", mediaHumorPorDia[dias]);
        }
        System.out.println();

    }
}

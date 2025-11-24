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
        double [] mediaHumorPorDias = mediaHumorPorDia(moodMap);
        formatarMediaPorDia(mediaHumorPorDias, moodMap);

        // d)
        mediaHumorPorPessoa(moodMap);

        // e)
        double maiorMedia = encontrarMaiorMedia(mediaHumorPorDias);
        System.out.printf("e) Days with the highest average mood (%.1f) : ",maiorMedia);
        diasComMaiorMedia(mediaHumorPorDias, maiorMedia);

        // f)
        System.out.println();
        percentagemNiveisHumor(moodMap);

        // g)
        contagemDiasConsecutivos(moodMap);
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
    public static double[] mediaHumorPorDia(int[][] moodMap) {
        double [] mediaHumorPorDias = new double[moodMap[0].length]; // array para armazenar o valor das médias
        for (int coluna = 0; coluna < moodMap[0].length; coluna++) { // vai percorrer cada dia/coluna
            double somaColuna = 0.0;
            for (int linha = 0; linha < moodMap.length; linha++) { // vai percorrer cada pessoa/linha
                somaColuna += moodMap[linha][coluna]; // calcula a soma dos elementos da coluna
            }
            double mediaPorDia = somaColuna / moodMap.length; // calcula a media dos elementos da coluna
            mediaHumorPorDias[coluna] = mediaPorDia; // armazena o valor da média no array
        }
        return mediaHumorPorDias;
    }

    public static void formatarMediaPorDia(double[] mediaHumorPorDia, int [][] moodMap) {
        System.out.println("c) Average mood each day:");
        formatarDias(moodMap);
        //para cada coluna/dia vai imprimir os números da matriz
        System.out.print("mood       ");
        for (int dias = 0; dias < mediaHumorPorDia.length; dias++) {
            System.out.printf("%.1f ", mediaHumorPorDia[dias]);
        }
        System.out.println();
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
        formatarMediaPorPessoa(mediaHumorPorPessoa);
    }

    public static void formatarMediaPorPessoa(double[] mediaHumorPorPessoa) {
        //vai imprimir para cada pessoa/linha o respetivo número da pessoa
        for (int pessoa = 0; pessoa < mediaHumorPorPessoa.length; pessoa++) {
            System.out.printf("Person #%d : ", pessoa);
            System.out.printf("%.1f ", mediaHumorPorPessoa[pessoa]);
            System.out.println();
        }
        System.out.println();
    }

    // e)
    public static double encontrarMaiorMedia(double [] mediaHumorPorDias) { // percorre o array e encontra a maior media
        double maiorMedia = 0.0;
        for (int dia = 0; dia < mediaHumorPorDias.length; dia++) {
            if (mediaHumorPorDias[dia] > maiorMedia) {
                maiorMedia = mediaHumorPorDias[dia];
            }
        }

        return maiorMedia; // retorna o valor da maior media
    }

    public static void diasComMaiorMedia(double [] mediaHumorPorDias, double maiorMedia) {
        for (int dia = 0; dia < mediaHumorPorDias.length; dia++) {
            if (mediaHumorPorDias[dia] == maiorMedia) {
                System.out.print(dia + " ");
            }
        }
    }

    // f)
    public static void percentagemNiveisHumor(int[][] moodMap) {
        //contador para contar quantas vezes aparece cada nota, como as notas variam de 1-5, o array apenas precisa de 5 espaços
        int[][] contador = new int[2][6];


        for (int i=0; i < contador[0].length; i++) {
            // assim a parte de cima da matriz vai ter os valores de cada humor possivel (1,2,3,..)
            // enquanto a segunda linha da matriz vai ser preenchida de 0 para depois meter a contagem de cada número do humor
            contador[0][i] = i;
            contador[1][i] = 0;
        }

        for (int linhas = 0; linhas < moodMap.length; linhas++) {
            for (int colunas = 0; colunas < moodMap[linhas].length; colunas++) {
                // a variável humor vai buscar o número especifico do humor naquele dia
                int humor = moodMap[linhas][colunas];
                // depois o valor é comparado com a tabela do contador e é adicionado +1 ao respetivo número
                if (humor == contador[0][humor]) {
                    contador[1][humor]++;
                }
            }
        }
        formatarPercentagemNiveisHumor(contador, moodMap);
    }

    public static void formatarPercentagemNiveisHumor(int[][] contador, int [][] moodMap) {
        System.out.println();
        System.out.println("f) Percentage of mood levels:");
        double percentagem;
        // a variável numTotal guarda o número de dias * pessoas, que é o número total de moods.
        int numTotal = moodMap.length * moodMap[0].length;
        // para formatar do mood com um número maior, é preciso começar pelo fim do array
        // como a array começa no 0 e vai ao 5, o comando contador[0].length ia dar 6, que é inválido e dá erro
        // para fazer corretamente a contagem decrescente, é preciso começar no 5 (contador[0].length-1) até ao 0
        for (int nivelHumor = contador[0].length - 1; nivelHumor >= 0; nivelHumor--)
            if (contador[1][nivelHumor] > 0) {
                // a percentagem é a quantidade de vezes que o número específico foi utilizado / numero total de moods * 100
                percentagem = (double) contador[1][nivelHumor] / numTotal * 100;
                System.out.printf("Mood #%d : %.1f%% \n", contador[0][nivelHumor], percentagem);
            }

    }

    // g)
    public static void contagemDiasConsecutivos(int[][] moodMap) {
        int [] guardarDiasConsecutivos = new int[moodMap.length]; // array para guardar a contagem de dias com transtorno emocional
        for (int linhas = 0; linhas < moodMap.length; linhas++) {
            int diasConsecutivos = 1;
            int diasConsecutivosMaximo = 1;
            for (int dia = 1; dia < moodMap[linhas].length; dia++) {
                if (moodMap[linhas][dia] < 3 && moodMap[linhas][dia - 1] < 3) { // verifica se os números do array formam sequência de números inferiores a 3
                    diasConsecutivos++; // tamanho da sequência
                    if (diasConsecutivos > diasConsecutivosMaximo) { // para determinarmos a maior sequência de dias com transtorno
                        diasConsecutivosMaximo = diasConsecutivos;
                    }
                }else  {
                    diasConsecutivos = 1; // recomeçar a contagem da sequência quando esta acaba
                }
            }
            guardarDiasConsecutivos[linhas] = diasConsecutivosMaximo;// guarda os valores da maior sequência por pessoa

        }
        pessoasComTranstornoEmocional(guardarDiasConsecutivos);
    }

    public static void pessoasComTranstornoEmocional(int[] diasConsecutivos) {          //FALTA OUTPUT "NINGUEM"
        System.out.println("g) People with emotional disorders:");
        for (int dia = 0; dia < diasConsecutivos.length; dia++) {
            if (diasConsecutivos[dia] != 1) {
                System.out.printf("Person #%d : ", dia);
                System.out.printf("%d consecutive days ", diasConsecutivos[dia]);
                System.out.println();
            }
        }
    }

}

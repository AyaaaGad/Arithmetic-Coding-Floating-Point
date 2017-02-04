
import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class Floating extends javax.swing.JFrame {

    public Floating() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("Compress");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 0));
        jButton2.setText("Decompress");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 102));
        jLabel1.setText("Enter your choice :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
     public class element
    {
        private String letter ;
        private double probability ;
        private double low_range ;
        private double high_range ;

        public element(String letter, double probability, double low_range, double high_range) {
            this.letter = letter;
            this.probability = probability;
            this.low_range = low_range;
            this.high_range = high_range;
        }
       
        public element() {}

        public void setLetter(String letter) {
            this.letter = letter;
        }

        public void setProbability(double probability) {
            this.probability = probability;
        }

        public void setLow_range(double low_range) {
            this.low_range = low_range;
        }

        public void setHigh_range(double high_range) {
            this.high_range = high_range;
        }

        public String getLetter() {
            return letter;
        }

        public double getProbability() {
            return probability;
        }

        public double getLow_range() {
            return low_range;
        }

        public double getHigh_range() {
            return high_range;
        }

       
    }
    
    Scanner sc;

    public void open_file(String FileName) {
        try {
            sc = new Scanner(new File(FileName));
        } catch (Exception e) {
            jLabel2.setText("Can not find File ");
        }
    }

    public void close_file() {
        sc.close();
    }

    Formatter out; //34an yktb el tag be format el string

    public void openfile(String pass) {
        try {
            out = new Formatter(pass);
        } catch (Exception e) {
            jLabel2.setText("Can not find File ");
        }

    }

    public void closefile() {
        out.close();
    }

    public void write(String code) {

        out.format("%s", code);
        out.format("%n");
        out.flush(); // 34an yktb 3al file

    }
    
      public String read_file(String FileName) // read input data 
      {
        open_file(FileName);
        String data = "";

        while (sc.hasNext()) // while it's not the end of file 
        {
            data += sc.nextLine(); // read line then append " ignore white spaces "

        }

        close_file();
        return data ;
      }
      
    ArrayList < element > elements_comp  = new ArrayList <element>(); // array b5zn feeh el 7rof bel probablity wel ranges fel compression
    ArrayList < element > elements_decomp  = new ArrayList <element>(); // array b5zn feeh el 7rof bel probablity wel ranges fel Decompression
  
    
    public void calculate_range (  ArrayList < element >  arr ) // comulative probability 
    {
        double low = 0 ;
        
        for (int i=0 ; i<arr.size() ; i++) 
        {
           double high = arr.get(i).getProbability()+low ; // el high range = prob + low ely 2abli
           arr.get(i).setLow_range(low);
           arr.get(i).setHigh_range(high);
           low = high ; 
        }
        
    }
    
    public void calculate_probability(String data)
    {
        for (int i = 0; i < data.length(); i++)  // count frequency 
        {
            String letter = "" ;
            letter += data.charAt(i); 
           
            boolean found = false;

            for (int j = 0; j < elements_comp.size(); j++) // loop 3ala l array of elements 
            {
                if (elements_comp.get(j).getLetter().equals(letter)) // law l 7arf da mwgod 2abl kda 
                {
                    double new_prob = elements_comp.get(j).getProbability()+1 ; // bnzwd el freq bta3o be wa7d 
                    elements_comp.get(j).setProbability(new_prob); 
                    found = true; // 34an maydef4 el 7arf da l2no geh 2abl kda 
                    break;
                }
            }

            if (found == false) // law el 7arf da awl mara yegi ha3mlo add wel freq =1 
            {
                elements_comp.add(new element (letter , 1 , 0 , 0 )); 
            }

        }
        
        
        for (int i=0 ; i<elements_comp.size() ; i++) //calculate probability
        {
            double new_prob = elements_comp.get(i).getProbability()/data.length();
            elements_comp.get(i).setProbability(new_prob);

        }
        
        calculate_range(elements_comp);
        
        for (int i=0 ; i<elements_comp.size() ; i++) 
        {
            System.out.println(elements_comp.get(i).getLetter() + " " + elements_comp.get(i).getProbability() + " " + elements_comp.get(i).getLow_range() + " " + elements_comp.get(i).getHigh_range());
        }

    }
      
   
    public element search_item (char x , ArrayList <element> arr) // bdelo el 7arf yrgli byanato ( probability , low range , high range )
    {
        String item = "";
        item+=x ;
        element result = new element () ;
        
        for (int i=0 ; i<arr.size() ; i++)
        {
            if (arr.get(i).getLetter().equals(item))
            {
                result = arr.get(i);
                break;
                
            }
        }
        
        return result ;
    }
    
    public void save_probabilities() // b3ml save lel 7arf wel prob bt3to 3ala file 34an ast5dmha again fel decomp
    {
        for (int i=0 ; i<elements_comp.size() ; i++)
        {   
            String item = elements_comp.get(i).getLetter() + elements_comp.get(i).getProbability();
            write(item);
        }
                
    }
    
    
     public void compress ()
    {   
        String data = read_file("Original Data.txt");
        calculate_probability(data);
        
        for (int i=0 ; i<elements_comp.size() ; i++) 
        {
            System.out.println(elements_comp.get(i).getLetter() + " " + elements_comp.get(i).getProbability() + " " + elements_comp.get(i).getLow_range() + " " + elements_comp.get(i).getHigh_range());
        }
        
        
        double lower = 0 ; // da el cur iteraion 
        double upper = 1 ;
        
        double old_lower = 0 ; // el prev iteration
        double old_upper = 1 ;
        
        
        for (int i=0 ; i<data.length() ; i++)
        {
            element cur = search_item (data.charAt(i) , elements_comp); // brou7 ageb el info bta3t el cur 7rf
            
            
            
            lower  = old_lower + (old_upper - old_lower )*cur.getLow_range(); // b3ml expand lel range bta3o ... b7sblo range gded
            upper  = old_lower + (old_upper - old_lower )*cur.getHigh_range(); // note b3ml old lower 34an law m3mltha4 bya5od el lower eli lsa tal3 mn el equation eli 2abli y7oto fe el upper we m4 da el mtlob

            
            old_lower = lower ; // we a5ly el range eli na feeh da yb2a el adem 34an ast5dmo fel next interation 
            old_upper = upper ;
            
            System.out.println("Range  = " + lower + " , " + upper);
          
        }
                
        double rand_num = (lower + upper)/2 ; // pick a num between final range 
        String code = Double.toString(rand_num);
        
        int length = data.length();
        String iterations = Integer.toString(length);
        
        openfile("Compressed Data.txt");  // save number & length & prob 3ala l file
        
        write(code);
        write(iterations);
        save_probabilities ();
        
        closefile();
        
        
        System.out.println("code = " + code );
        
    }
    
    
    public void reconstruct_probabilities () // read letters and thier probablity from file and calculate commulative ranges for each one
    {
        while (sc.hasNext()) 
        {
            String data = sc.nextLine();
            String letter = "" + data.charAt(0) ;
            elements_decomp.add(new element ( letter , Double.parseDouble(data.substring(1)) , 0 , 0 )) ;

        }
        
        calculate_range(elements_decomp);
  
    }
    
    
     public void decompress ()
    {
        open_file("Compressed Data.txt");
       
        double code = Double.parseDouble(sc.nextLine()); // read float num
        int iterations = Integer.parseInt(sc.nextLine()); // read length
        
        reconstruct_probabilities(); // read prob 
        
        close_file();
        
        System.out.println("------------------------------------------------");
       
        for (int i=0 ; i<elements_decomp.size() ; i++) 
        {
            System.out.println(elements_decomp.get(i).getLetter() + " " + elements_decomp.get(i).getProbability() + " " + elements_decomp.get(i).getLow_range() + " " + elements_decomp.get(i).getHigh_range());
        }
        
        
        String stream = ""; // el output data 
        
        double lower = 0 , upper = 1  ;   // same idea of comp
        double old_lower = 0 , old_upper = 1  ;
        
        for (int i=0 ; i<iterations ; i++) 
        {    
            double cur_code = (code - old_lower) / (old_upper - old_lower) ;  // b7sb el code lel iteration li na feha 
            
            System.out.println("cur code = " + cur_code);
            
            System.out.println("lower = " + lower);
            System.out.println("upper = " + upper);
            
            for (int j=0 ; j<elements_decomp.size() ; j++)
            {
                if ( (cur_code > elements_decomp.get(j).getLow_range()) && ( cur_code < elements_decomp.get(j).getHigh_range())) // b4ofo howa fe anhy range
                {
                    stream += elements_decomp.get(j).getLetter(); // bgeeb el 7arf el mokabel lel range dah 
                    lower = old_lower + (old_upper - old_lower)*elements_decomp.get(j).getLow_range(); // b3ml lel 7arf da new range ... expand
                    upper = old_lower + (old_upper - old_lower)*elements_decomp.get(j).getHigh_range();
                    
                    old_lower = lower ;
                    old_upper = upper ;
                   
                    break;
                }
                
            }
            
        }
        
        openfile("Decompressed Data.txt");
        
        write(stream);
        
        closefile();
        
        System.out.println("stream = " + stream);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        compress ();   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        decompress (); 
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Floating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Floating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Floating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Floating.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Floating().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

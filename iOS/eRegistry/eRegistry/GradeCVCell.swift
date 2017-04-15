//
//  GradeCVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class GradeCVCell: UICollectionViewCell {

    @IBOutlet weak var colorView: UIView!
    @IBOutlet weak var gradeLabel: UILabel!
    @IBOutlet weak var subjectLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setSubject(_ subject: Subject) {
        gradeLabel.text = "\(subject.averageGrade)"
        subjectLabel.text = subject.name
        colorView.backgroundColor = Colors.getColor(forGrade: subject.averageGrade)
        //colorView.backgroundColor = Colors.calculateColor(for: subject.averageGrade, fromInterval: [1,5], usingGradient: [.red, .yellow, .green])
    }

}

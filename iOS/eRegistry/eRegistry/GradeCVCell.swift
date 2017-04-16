//
//  GradeCVCell.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 14.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class GradeCVCell: UICollectionViewCell {

    @IBOutlet weak var colorView: UIView! {
        didSet {
            colorView.layer.borderColor = UIColor.white.cgColor
            colorView.layer.borderWidth = 1.0
            colorView.layer.cornerRadius = 6.0
        }
    }
    @IBOutlet weak var gradeLabel: UILabel!
    @IBOutlet weak var subjectLabel: UILabel!
    @IBOutlet weak var progressBackground: UIView! {
        didSet {
            progressBackground.layer.borderColor = UIColor.white.cgColor
            progressBackground.layer.borderWidth = 1.0
            progressBackground.layer.cornerRadius = progressBackground.frame.height/2
        }
    }
    @IBOutlet weak var progressView: UIView! {
        didSet {
            progressView.layer.cornerRadius = progressView.frame.height/2
        }
    }
    @IBOutlet weak var progressTrailing: NSLayoutConstraint! {
        didSet {
            progressTrailing.constant = self.bounds.width - PROGRESS_TOTAL_MARGIN
        }
    }
    
    var subject: Subject?
    
    let BEST_GRADE: CGFloat = 5
    
    let PROGRESS_TOTAL_MARGIN: CGFloat = 64
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setConstraints() {
        guard let subjectObj = subject else {
            return
        }
        progressView.translatesAutoresizingMaskIntoConstraints = false
        let trailing = ((self.BEST_GRADE - subjectObj.averageGrade)/BEST_GRADE)*((bounds.width)-PROGRESS_TOTAL_MARGIN)
        progressTrailing.constant = trailing
    }
    
    func setSubject(_ subject: Subject) {
        self.subject = subject
        gradeLabel.text = String(format: "%.2f", subject.averageGrade)
        gradeLabel.adjustsFontSizeToFitWidth = true
        gradeLabel.minimumScaleFactor = 0.9
        subjectLabel.text = subject.name
        progressView.backgroundColor = Colors.getColor(forGrade: subject.averageGrade)
        
        print(self.bounds.width)
        setConstraints()
    }

}

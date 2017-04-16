//
//  SubjectHeaderView.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class SubjectHeaderView: UIView {

    @IBOutlet weak var container: UIView! {
        didSet {
            container.backgroundColor = Colors.MAIN
        }
    }
    @IBOutlet weak var dateLabel: UILabel! {
        didSet {
            dateLabel.text = "Data"
            dateLabel.textColor = .white
        }
    }
    @IBOutlet weak var descriptionLabel: UILabel! {
        didSet {
            descriptionLabel.text = "Opis"
            descriptionLabel.textColor = .white
        }
    }
    @IBOutlet weak var gradeLabel: UILabel! {
        didSet {
            gradeLabel.text = "Ocena"
            gradeLabel.textColor = .white
        }
    }

}

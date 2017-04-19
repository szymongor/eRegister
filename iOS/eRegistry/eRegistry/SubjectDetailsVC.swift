//
//  SubjectDetailsVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 16.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class SubjectDetailsVC: UIViewController {

    @IBOutlet weak var tableView: UITableView! {
        didSet {
            let cellNib = UINib(nibName: CELL_ID, bundle: nil)
            tableView.register(cellNib, forCellReuseIdentifier: CELL_ID)
            tableView.delegate = self
            tableView.dataSource = self
            tableView.rowHeight = UITableViewAutomaticDimension
            tableView.estimatedRowHeight = 44
            tableView.backgroundColor = Colors.MAIN
        }
    }
    
    let CELL_ID = "SubjectDetailsTVCell"
    let HEADER_HEIGHT: CGFloat = 64
    
    var subject: Subject?
    
    override func viewDidLoad() {
        super.viewDidLoad()
                    tableView.separatorColor = Colors.MAIN

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func setSubject(_ subject: Subject?) {
        self.subject = subject
        self.title = subject?.name
    }

}

extension SubjectDetailsVC: UITableViewDelegate, UITableViewDataSource {
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        guard let cell = tableView.dequeueReusableCell(withIdentifier: CELL_ID, for: indexPath) as? SubjectDetailsTVCell else {
            return UITableViewCell()
        }
        let grade = subject?.grades[indexPath.row]
        cell.setView(for: grade)
        return cell
    }
    
    func numberOfSections(in tableView: UITableView) -> Int {
        return 1
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        guard let subjectObj = subject else {
            return 0
        }
        return subjectObj.grades.count
    }
    
    func tableView(_ tableView: UITableView, viewForHeaderInSection section: Int) -> UIView? {
        guard let header = UINib(nibName: "SubjectHeaderView", bundle: nil).instantiate(withOwner: self, options: nil).first as? SubjectHeaderView else {
            return UIView()
        }
        return header
    }
    
    func tableView(_ tableView: UITableView, heightForHeaderInSection section: Int) -> CGFloat {
        return HEADER_HEIGHT
    }
    
}

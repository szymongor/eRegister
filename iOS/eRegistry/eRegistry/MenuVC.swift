//
//  MenuVC.swift
//  eRegistry
//
//  Created by Kryg Tomasz on 11.04.2017.
//  Copyright © 2017 Kryg Tomek. All rights reserved.
//

import UIKit

class MenuVC: UIViewController {

//    @IBOutlet weak var collectionView: UICollectionView! {
//        didSet {
//            let cellNib = UINib(nibName: "MenuCVCell", bundle: nil)
//            collectionView.register(cellNib, forCellWithReuseIdentifier: "MenuCVCell")
//            collectionView.delegate = self
//            collectionView.dataSource = self
//        }
//    }
    
    //let NUMBER_OF_ROWS: CGFloat = 3
    //let NUMBER_OF_COLUMNS: CGFloat = 2
    
    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

}

//extension MenuVC: UICollectionViewDelegate, UICollectionViewDataSource {
//    
//    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
//        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "MenuCVCell", for: indexPath)
//        cell.backgroundColor = UIColor.red
//        return cell
//    }
//    
//    func numberOfSections(in collectionView: UICollectionView) -> Int {
//        return 1
//    }
//    
//    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
//        return 6
//    }
//    
//}
//
//extension MenuVC: UICollectionViewDelegateFlowLayout {
//    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
//        var cellEdge = 0
//        let cellWidth = collectionView.bounds.width/NUMBER_OF_COLUMNS
//        let cellHeight = collectionView.bounds.height/NUMBER_OF_ROWS
//        cellEdge = Int(cellWidth < cellHeight ? cellWidth : cellHeight)
//        return CGSize(width: cellEdge, height: cellEdge)
//    }
//    
//    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, insetForSectionAt section: Int) -> UIEdgeInsets {
//        return UIEdgeInsetsMake(0, 0, 0, 0)
//    }
//
//}
